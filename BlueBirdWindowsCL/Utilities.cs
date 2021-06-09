﻿using System;
using System.Collections.Generic;
using System.Linq;
using Windows.Storage.Streams;
using Windows.Devices.Enumeration;

namespace BlueBirdWindowsCL
{
    public static class Utilities
    {
        public static void WriteOut(string packetType, string[] data)
        {
            string message = "{\"packetType\": \"" + packetType + "\", ";
            for(int i = 0; i<data.Length; i++)
            {
                message += "\"" + data[i] + "\"";
                message += (i % 2 == 0) ? ": " : ",";
            }
            message = message.TrimEnd(',');
            message += "}";
            Console.WriteLine(message);
        }
        public static void WriteError(string errorMessage)
        {
            Utilities.WriteOut("ERROR", new string[] { "message", errorMessage });
        }
        public static void WriteConnectionUpdate(string status, Robot robot)
        {
            var args = new string[] { "status", status, "peripheral", robot.Name, "hasV2", robot.hasV2.ToString() };
            Utilities.WriteOut("connection", args);
        }

        /// <summary>
        ///     Converts from standard 128bit UUID to the assigned 32bit UUIDs. Makes it easy to compare services
        ///     that devices expose to the standard list.
        /// </summary>
        /// <param name="uuid">UUID to convert to 32 bit</param>
        /// <returns></returns>
        public static ushort ConvertUuidToShortId(Guid uuid)
        {
            // Get the short Uuid
            var bytes = uuid.ToByteArray();
            var shortUuid = (ushort)(bytes[0] | (bytes[1] << 8));
            return shortUuid;
        }

        /// <summary>
        ///     Converts from a buffer to a properly sized byte array
        /// </summary>
        /// <param name="buffer"></param>
        /// <returns></returns>
        public static byte[] ReadBufferToBytes(IBuffer buffer)
        {
            var dataLength = buffer.Length;
            var data = new byte[dataLength];
            using (var reader = DataReader.FromBuffer(buffer))
            {
                reader.ReadBytes(data);
            }
            return data;
        }

        /// <summary>
        /// This function is trying to find device or service or attribute by name or number
        /// </summary>
        /// <param name="collection">source collection</param>
        /// <param name="name">name or number to find</param>
        /// <returns>ID for device, Name for services or attributes</returns>
        public static string GetIdByNameOrNumber(object collection, string name)
        {
            string result = string.Empty;

            // If number is specified, try to open BLE device by specific number
            if (name[0] == '#')
            {
                int devNumber = -1;
                if (int.TryParse(name.Substring(1), out devNumber))
                {
                    // Try to find device ID by number
                    if (collection is List<DeviceInformation>)
                    {
                        if (0 <= devNumber && devNumber < (collection as List<DeviceInformation>).Count)
                        {
                            result = (collection as List<DeviceInformation>)[devNumber].Id;
                        }
                        else
                            if (Console.IsOutputRedirected)
                            Console.WriteLine("Device number {0:00} is not in device list range", devNumber);
                    }
                    // for services or attributes
                    else
                    {
                        if (0 <= devNumber && devNumber < (collection as List<BluetoothLEAttributeDisplay>).Count)
                        {
                            result = (collection as List<BluetoothLEAttributeDisplay>)[devNumber].Name;
                        }
                    }
                }
                else
                    if (!Console.IsOutputRedirected)
                    Console.WriteLine("Invalid device number {0}", name.Substring(1));
            }
            // else try to find name
            else
            {
                // ... for devices
                if (collection is List<DeviceInformation>)
                {
                    var foundDevices = (collection as List<DeviceInformation>).Where(d => d.Name.ToLower().StartsWith(name.ToLower())).ToList();
                    if (foundDevices.Count == 0)
                    {
                        if (!Console.IsOutputRedirected)
                            Console.WriteLine("Can't connect to {0}.", name);
                    }
                    else if (foundDevices.Count == 1)
                    {
                        result = foundDevices.First().Id;
                    }
                    else
                    {
                        if (!Console.IsOutputRedirected)
                            Console.WriteLine("Found multiple devices with names started from {0}. Please provide an exact name.", name);
                    }
                }
                // for services or attributes
                else
                {
                    var foundDispAttrs = (collection as List<BluetoothLEAttributeDisplay>).Where(d => d.Name.ToLower().StartsWith(name.ToLower())).ToList();
                    if (foundDispAttrs.Count == 0)
                    {
                        if (Console.IsOutputRedirected)
                            Console.WriteLine("No service/characteristic found by name {0}.", name);
                    }
                    else if (foundDispAttrs.Count == 1)
                    {
                        result = foundDispAttrs.First().Name;
                    }
                    else
                    {
                        if (Console.IsOutputRedirected)
                            Console.WriteLine("Found multiple services/characteristic with names started from {0}. Please provide an exact name.", name);
                    }
                }
            }
            return result;
        }
    }
}