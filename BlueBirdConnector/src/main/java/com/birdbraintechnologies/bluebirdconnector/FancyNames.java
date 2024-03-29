package com.birdbraintechnologies.bluebirdconnector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FancyNames {
    static final Logger LOG = LoggerFactory.getLogger(FancyNames.class);

    /**
     * Array of names to choose from. One name will be chosen from each column.
     */
    private static String[][] names = new String[][]{
            { "Adorable", "Amber", "Beaver" },
            {"Adventurous", "Amethyst", "Bee"},
            {"Agile", "Apricot", "Canary"},
            {"Amazing", "Arboreal", "Cat"},
            {"Ancient", "Arctic", "Catfish"},
            {"Artistic", "Banana", "Centaur"},
            {"Astounding", "Blue", "Chicken"},
            {"Athletic", "Brass", "Coyote"},
            {"Awesome", "Cave", "Cricket"},
            {"Beautiful", "Celestial", "Dinosaur"},
            {"Benevolent", "Citrine", "Dog"},
            {"Big", "Cloud", "Dolphin"},
            {"Blazing", "Cobalt", "Dragon"},
            {"Blissful", "Copper", "Dragonfly"},
            {"Blushing", "Crystal", "Eagle"},
            {"Bold", "Desert", "Elephant"},
            {"Bouncy", "Diamond", "Falcon"},
            {"Breezy", "Emerald", "Flamingo"},
            {"Bright", "Fire", "Fox"},
            {"Brilliant", "Forest", "Giraffe"},
            {"Bubbly", "Fuchsia", "Grasshopper"},
            {"Bumpy", "Gold", "Griffin"},
            {"Busy", "Gray", "Hamster"},
            {"Calm", "Green", "Hawk"},
            {"Camouflaged", "Indigo", "Hippogriff"},
            {"Carefree", "Jade", "Hippopotamus"},
            {"Caring", "Jungle", "Horse"},
            {"Carnivorous", "Lava", "Inchworm"},
            {"Charming", "Lavender", "Kitten"},
            {"Cheerful", "Lightning", "Kraken"},
            {"Cheesy", "Lime", "Lemur"},
            {"Classy", "Magenta", "Leopard"},
            {"Colossal", "Maroon", "Lion"},
            {"Comfortable", "Moonstone", "Lizard"},
            {"Cool", "Mountain", "Manatee"},
            {"Corny", "Navy", "Monkey"},
            {"Courageous", "Ocean", "Narwhal"},
            {"Cozy", "Olive", "Octopus"},
            {"Crawling", "Onyx", "Parrot"},
            {"Crazy", "Opal", "Phoenix"},
            {"Creative", "Orange", "Platypus"},
            {"Cuddly", "Pearl", "Pony"},
            {"Cunning", "Pink", "Porcupine"},
            {"Dainty", "Platinum", "Puppy"},
            {"Dancing", "Plum", "Raccoon"},
            {"Dapper", "Purple", "Rooster"},
            {"Daring", "Quartz", "Seahorse"},
            {"Dark", "Rainforest", "Sloth"},
            {"Dashing", "Red", "Slug"},
            {"Delightful", "River", "Snail"},
            {"Deluxe", "Ruby", "Sphinx"},
            {"Determined", "Sand", "Squid"},
            {"Doubtful", "Sapphire", "Squirrel"},
            {"Dreaming", "Scarlet", "Stegosaurus"},
            {"Dry", "Silver", "Tiger"},
            {"Educated", "Sky", "Timberwolf"},
            {"Elder", "Snow", "Tuna"},
            {"Endearing", "Space", "Tyrannosaurus"},
            {"Energetic", "Tangerine", "Unicorn"},
            {"Engaging", "Teal", "Velociraptor"},
            {"Enormous", "Titanium", "Walrus"},
            {"Entertaining", "Topaz", "Whale"},
            {"Exciting", "Violet", "Wolf"},
            {"Extraordinary", "Yellow", "Zebra"},
            {"Fanciful", "Amber", "Beaver"},
            {"Fantastic", "Amethyst", "Bee"},
            {"Fast", "Apricot", "Canary"},
            {"Fearless", "Arboreal", "Cat"},
            {"Feathered", "Arctic", "Catfish"},
            {"Feisty", "Banana", "Centaur"},
            {"Feral", "Blue", "Chicken"},
            {"Fierce", "Brass", "Coyote"},
            {"Floppy", "Cave", "Cricket"},
            {"Fluffy", "Celestial", "Dinosaur"},
            {"Flying", "Citrine", "Dog"},
            {"Friendly", "Cloud", "Dolphin"},
            {"Frosty", "Cobalt", "Dragon"},
            {"Funny", "Copper", "Dragonfly"},
            {"Furry", "Crystal", "Eagle"},
            {"Fuzzy", "Desert", "Elephant"},
            {"Galactic", "Diamond", "Falcon"},
            {"Gargantuan", "Emerald", "Flamingo"},
            {"Generous", "Fire", "Fox"},
            {"Gentle", "Forest", "Giraffe"},
            {"Genuine", "Fuchsia", "Grasshopper"},
            {"Giant", "Gold", "Griffin"},
            {"Giggly", "Gray", "Hamster"},
            {"Ginormous", "Green", "Hawk"},
            {"Glacial", "Indigo", "Hippogriff"},
            {"Glamorous", "Jade", "Hippopotamus"},
            {"Gleeful", "Jungle", "Horse"},
            {"Glistening", "Lava", "Inchworm"},
            {"Glittery", "Lavender", "Kitten"},
            {"Glossy", "Lightning", "Kraken"},
            {"Glowing", "Lime", "Lemur"},
            {"Good", "Magenta", "Leopard"},
            {"Goofy", "Maroon", "Lion"},
            {"Gorgeous", "Moonstone", "Lizard"},
            {"Graceful", "Mountain", "Manatee"},
            {"Great", "Navy", "Monkey"},
            {"Groovy", "Ocean", "Narwhal"},
            {"Grumpy", "Olive", "Octopus"},
            {"Gutsy", "Onyx", "Parrot"},
            {"Hairy", "Opal", "Phoenix"},
            {"Happy", "Orange", "Platypus"},
            {"Heavy", "Pearl", "Pony"},
            {"Helpful", "Pink", "Porcupine"},
            {"Heroic", "Platinum", "Puppy"},
            {"Hidden", "Plum", "Raccoon"},
            {"Hopeful", "Purple", "Rooster"},
            {"Hopping", "Quartz", "Seahorse"},
            {"Huge", "Rainforest", "Sloth"},
            {"Humongous", "Red", "Slug"},
            {"Humorous", "River", "Snail"},
            {"Hungry", "Ruby", "Sphinx"},
            {"Hyper", "Sand", "Squid"},
            {"Icy", "Sapphire", "Squirrel"},
            {"Idealistic", "Scarlet", "Stegosaurus"},
            {"Imaginative", "Silver", "Tiger"},
            {"Impressive", "Sky", "Timberwolf"},
            {"Incredible", "Snow", "Tuna"},
            {"Ingenious", "Space", "Tyrannosaurus"},
            {"Inky", "Tangerine", "Unicorn"},
            {"Innovative", "Teal", "Velociraptor"},
            {"Inspiring", "Titanium", "Walrus"},
            {"Intellectual", "Topaz", "Whale"},
            {"Interesting", "Violet", "Wolf"},
            {"Interstellar", "Yellow", "Zebra"},
            {"Intrepid", "Amber", "Beaver"},
            {"Itty-Bitty", "Amethyst", "Bee"},
            {"Jazzy", "Apricot", "Canary"},
            {"Jiggly", "Arboreal", "Cat"},
            {"Joking", "Arctic", "Catfish"},
            {"Jovial", "Banana", "Centaur"},
            {"Joyful", "Blue", "Chicken"},
            {"Jumpy", "Brass", "Coyote"},
            {"Lacy", "Cave", "Cricket"},
            {"Large", "Celestial", "Dinosaur"},
            {"Laughing", "Citrine", "Dog"},
            {"Lazy", "Cloud", "Dolphin"},
            {"Leafy", "Cobalt", "Dragon"},
            {"Light", "Copper", "Dragonfly"},
            {"Lively", "Crystal", "Eagle"},
            {"Long", "Desert", "Elephant"},
            {"Loony", "Diamond", "Falcon"},
            {"Loud", "Emerald", "Flamingo"},
            {"Lovely", "Fire", "Fox"},
            {"Loyal", "Forest", "Giraffe"},
            {"Lucky", "Fuchsia", "Grasshopper"},
            {"Lyrical", "Gold", "Griffin"},
            {"Magical", "Gray", "Hamster"},
            {"Magnetic", "Green", "Hawk"},
            {"Majestic", "Indigo", "Hippogriff"},
            {"Marvelous", "Jade", "Hippopotamus"},
            {"Masterful", "Jungle", "Horse"},
            {"Mega", "Lava", "Inchworm"},
            {"Merry", "Lavender", "Kitten"},
            {"Metallic", "Lightning", "Kraken"},
            {"Micro", "Lime", "Lemur"},
            {"Mighty", "Magenta", "Leopard"},
            {"Mini", "Maroon", "Lion"},
            {"Mischievous", "Moonstone", "Lizard"},
            {"Muscular", "Mountain", "Manatee"},
            {"Musical", "Navy", "Monkey"},
            {"Mutant", "Ocean", "Narwhal"},
            {"Mysterious", "Olive", "Octopus"},
            {"Mythical", "Onyx", "Parrot"},
            {"Nice", "Opal", "Phoenix"},
            {"Nocturnal", "Orange", "Platypus"},
            {"Noticeable", "Pearl", "Pony"},
            {"Optimistic", "Pink", "Porcupine"},
            {"Outdoorsy", "Platinum", "Puppy"},
            {"Painted", "Plum", "Raccoon"},
            {"Patient", "Purple", "Rooster"},
            {"Peaceful", "Quartz", "Seahorse"},
            {"Perfect", "Rainforest", "Sloth"},
            {"Persistent", "Red", "Slug"},
            {"Pigmy", "River", "Snail"},
            {"Playful", "Ruby", "Sphinx"},
            {"Polite", "Sand", "Squid"},
            {"Powerful", "Sapphire", "Squirrel"},
            {"Quick", "Scarlet", "Stegosaurus"},
            {"Quiet", "Silver", "Tiger"},
            {"Quirky", "Sky", "Timberwolf"},
            {"Random", "Snow", "Tuna"},
            {"Remarkable", "Space", "Tyrannosaurus"},
            {"Righteous", "Tangerine", "Unicorn"},
            {"Robotic", "Teal", "Velociraptor"},
            {"Rockin'", "Titanium", "Walrus"},
            {"Rough", "Topaz", "Whale"},
            {"Round", "Violet", "Wolf"},
            {"Royal", "Yellow", "Zebra"},
            {"Running", "Amber", "Beaver"},
            {"Scaly", "Amethyst", "Bee"},
            {"Scary", "Apricot", "Canary"},
            {"Shadowy", "Arboreal", "Cat"},
            {"Shiny", "Arctic", "Catfish"},
            {"Shy", "Banana", "Centaur"},
            {"Singing", "Blue", "Chicken"},
            {"Skating", "Brass", "Coyote"},
            {"Skeptical", "Cave", "Cricket"},
            {"Skipping", "Celestial", "Dinosaur"},
            {"Sleepy", "Citrine", "Dog"},
            {"Slippery", "Cloud", "Dolphin"},
            {"Slow", "Cobalt", "Dragon"},
            {"Small", "Copper", "Dragonfly"},
            {"Smiling", "Crystal", "Eagle"},
            {"Sneezy", "Desert", "Elephant"},
            {"Soaring", "Diamond", "Falcon"},
            {"Soft", "Emerald", "Flamingo"},
            {"Sparkly", "Fire", "Fox"},
            {"Speckled", "Forest", "Giraffe"},
            {"Spikey", "Fuchsia", "Grasshopper"},
            {"Spirited", "Gold", "Griffin"},
            {"Splendid", "Gray", "Hamster"},
            {"Spooky", "Green", "Hawk"},
            {"Spotted", "Indigo", "Hippogriff"},
            {"Spunky", "Jade", "Hippopotamus"},
            {"Squeaky", "Jungle", "Horse"},
            {"Squishy", "Lava", "Inchworm"},
            {"Starry", "Lavender", "Kitten"},
            {"Stealthy", "Lightning", "Kraken"},
            {"Stellar", "Lime", "Lemur"},
            {"Stretchy", "Magenta", "Leopard"},
            {"Striped", "Maroon", "Lion"},
            {"Strong", "Moonstone", "Lizard"},
            {"Super", "Mountain", "Manatee"},
            {"Surprised", "Navy", "Monkey"},
            {"Swimming", "Ocean", "Narwhal"},
            {"Tall", "Olive", "Octopus"},
            {"Tame", "Onyx", "Parrot"},
            {"Terrific", "Opal", "Phoenix"},
            {"Thorny", "Orange", "Platypus"},
            {"Thundering", "Pearl", "Pony"},
            {"Ticklish", "Pink", "Porcupine"},
            {"Tiny", "Platinum", "Puppy"},
            {"Traveling", "Plum", "Raccoon"},
            {"Tremendous", "Purple", "Rooster"},
            {"Triumphant", "Quartz", "Seahorse"},
            {"Truthful", "Rainforest", "Sloth"},
            {"Twirling", "Red", "Slug"},
            {"Ultra", "River", "Snail"},
            {"Unbelievable", "Ruby", "Sphinx"},
            {"Velvety", "Sand", "Squid"},
            {"Visionary", "Sapphire", "Squirrel"},
            {"Vivacious", "Scarlet", "Stegosaurus"},
            {"Vivid", "Silver", "Tiger"},
            {"Vocal", "Sky", "Timberwolf"},
            {"Warm", "Snow", "Tuna"},
            {"Wild", "Space", "Tyrannosaurus"},
            {"Winged", "Tangerine", "Unicorn"},
            {"Wise", "Teal", "Velociraptor"},
            {"Witty", "Titanium", "Walrus"},
            {"Wonderful", "Topaz", "Whale"},
            {"Young", "Violet", "Wolf"},
            {"Zealous", "Yellow", "Zebra"},
            {"Adorable", "Amber", "Beaver"},
            {"Adventurous", "Amethyst", "Bee"},
            {"Agile", "Apricot", "Canary"},
            {"Amazing", "Arboreal", "Cat"},
            {"Ancient", "Arctic", "Catfish"},
            {"Artistic", "Banana", "Centaur"},
            {"Astounding", "Blue", "Chicken"},
            {"Athletic", "Brass", "Coyote"},
            {"Awesome", "Cave", "Cricket"},
            {"Beautiful", "Celestial", "Dinosaur"},
            {"Benevolent", "Citrine", "Dog"},
            {"Big", "Cloud", "Dolphin"},
            {"Blazing", "Cobalt", "Dragon"},
            {"Blissful", "Copper", "Dragonfly"},
            {"Blushing", "Crystal", "Eagle"},
            {"Bold", "Desert", "Elephant"},
            {"Bouncy", "Diamond", "Falcon"},
            {"Breezy", "Emerald", "Flamingo"},
            {"Bright", "Fire", "Fox"},
            {"Brilliant", "Forest", "Giraffe"},
            {"Bubbly", "Fuchsia", "Grasshopper"},
            {"Bumpy", "Gold", "Griffin"},
            {"Busy", "Gray", "Hamster"},
            {"Calm", "Green", "Hawk"},
            {"Camouflaged", "Indigo", "Hippogriff"},
            {"Carefree", "Jade", "Hippopotamus"},
            {"Caring", "Jungle", "Horse"},
            {"Carnivorous", "Lava", "Inchworm"},
            {"Charming", "Lavender", "Kitten"},
            {"Cheerful", "Lightning", "Kraken"},
            {"Cheesy", "Lime", "Lemur"},
            {"Classy", "Magenta", "Leopard"},
            {"Colossal", "Maroon", "Lion"},
            {"Comfortable", "Moonstone", "Lizard"},
            {"Cool", "Mountain", "Manatee"},
            {"Corny", "Navy", "Monkey"},
            {"Courageous", "Ocean", "Narwhal"},
            {"Cozy", "Olive", "Octopus"},
            {"Crawling", "Onyx", "Parrot"},
            {"Crazy", "Opal", "Phoenix"},
            {"Creative", "Orange", "Platypus"},
            {"Cuddly", "Pearl", "Pony"},
            {"Cunning", "Pink", "Porcupine"},
            {"Dainty", "Platinum", "Puppy"},
            {"Dancing", "Plum", "Raccoon"},
            {"Dapper", "Purple", "Rooster"},
            {"Daring", "Quartz", "Seahorse"},
            {"Dark", "Rainforest", "Sloth"},
            {"Dashing", "Red", "Slug"},
            {"Delightful", "River", "Snail"},
            {"Deluxe", "Ruby", "Sphinx"},
            {"Determined", "Sand", "Squid"},
            {"Doubtful", "Sapphire", "Squirrel"},
            {"Dreaming", "Scarlet", "Stegosaurus"},
            {"Dry", "Silver", "Tiger"},
            {"Educated", "Sky", "Timberwolf"},
            {"Elder", "Snow", "Tuna"},
            {"Endearing", "Space", "Tyrannosaurus"},
            {"Energetic", "Tangerine", "Unicorn"},
            {"Engaging", "Teal", "Velociraptor"},
            {"Enormous", "Titanium", "Walrus"},
            {"Entertaining", "Topaz", "Whale"},
            {"Exciting", "Violet", "Wolf"},
            {"Extraordinary", "Yellow", "Zebra"},
            {"Fanciful", "Amber", "Beaver"},
            {"Fantastic", "Amethyst", "Bee"},
            {"Fast", "Apricot", "Canary"},
            {"Fearless", "Arboreal", "Cat"},
            {"Feathered", "Arctic", "Catfish"},
            {"Feisty", "Banana", "Centaur"},
            {"Feral", "Blue", "Chicken"},
            {"Fierce", "Brass", "Coyote"},
            {"Floppy", "Cave", "Cricket"},
            {"Fluffy", "Celestial", "Dinosaur"},
            {"Flying", "Citrine", "Dog"},
            {"Friendly", "Cloud", "Dolphin"},
            {"Frosty", "Cobalt", "Dragon"},
            {"Funny", "Copper", "Dragonfly"},
            {"Furry", "Crystal", "Eagle"},
            {"Fuzzy", "Desert", "Elephant"},
            {"Galactic", "Diamond", "Falcon"},
            {"Gargantuan", "Emerald", "Flamingo"},
            {"Generous", "Fire", "Fox"},
            {"Gentle", "Forest", "Giraffe"},
            {"Genuine", "Fuchsia", "Grasshopper"},
            {"Giant", "Gold", "Griffin"},
            {"Giggly", "Gray", "Hamster"},
            {"Ginormous", "Green", "Hawk"},
            {"Glacial", "Indigo", "Hippogriff"},
            {"Glamorous", "Jade", "Hippopotamus"},
            {"Gleeful", "Jungle", "Horse"},
            {"Glistening", "Lava", "Inchworm"},
            {"Glittery", "Lavender", "Kitten"},
            {"Glossy", "Lightning", "Kraken"},
            {"Glowing", "Lime", "Lemur"},
            {"Good", "Magenta", "Leopard"},
            {"Goofy", "Maroon", "Lion"},
            {"Gorgeous", "Moonstone", "Lizard"},
            {"Graceful", "Mountain", "Manatee"},
            {"Great", "Navy", "Monkey"},
            {"Groovy", "Ocean", "Narwhal"},
            {"Grumpy", "Olive", "Octopus"},
            {"Gutsy", "Onyx", "Parrot"},
            {"Hairy", "Opal", "Phoenix"},
            {"Happy", "Orange", "Platypus"},
            {"Heavy", "Pearl", "Pony"},
            {"Helpful", "Pink", "Porcupine"},
            {"Heroic", "Platinum", "Puppy"},
            {"Hidden", "Plum", "Raccoon"},
            {"Hopeful", "Purple", "Rooster"},
            {"Hopping", "Quartz", "Seahorse"},
            {"Huge", "Rainforest", "Sloth"},
            {"Humongous", "Red", "Slug"},
            {"Humorous", "River", "Snail"},
            {"Hungry", "Ruby", "Sphinx"},
            {"Hyper", "Sand", "Squid"},
            {"Icy", "Sapphire", "Squirrel"},
            {"Idealistic", "Scarlet", "Stegosaurus"},
            {"Imaginative", "Silver", "Tiger"},
            {"Impressive", "Sky", "Timberwolf"},
            {"Incredible", "Snow", "Tuna"},
            {"Ingenious", "Space", "Tyrannosaurus"},
            {"Inky", "Tangerine", "Unicorn"},
            {"Innovative", "Teal", "Velociraptor"},
            {"Inspiring", "Titanium", "Walrus"},
            {"Intellectual", "Topaz", "Whale"},
            {"Interesting", "Violet", "Wolf"},
            {"Interstellar", "Yellow", "Zebra"},
            {"Intrepid", "Amber", "Beaver"},
            {"Itty-Bitty", "Amethyst", "Bee"},
            {"Jazzy", "Apricot", "Canary"},
            {"Jiggly", "Arboreal", "Cat"},
            {"Joking", "Arctic", "Catfish"},
            {"Jovial", "Banana", "Centaur"},
            {"Joyful", "Blue", "Chicken"},
            {"Jumpy", "Brass", "Coyote"},
            {"Lacy", "Cave", "Cricket"},
            {"Large", "Celestial", "Dinosaur"},
            {"Laughing", "Citrine", "Dog"},
            {"Lazy", "Cloud", "Dolphin"},
            {"Leafy", "Cobalt", "Dragon"},
            {"Light", "Copper", "Dragonfly"},
            {"Lively", "Crystal", "Eagle"},
            {"Long", "Desert", "Elephant"},
            {"Loony", "Diamond", "Falcon"},
            {"Loud", "Emerald", "Flamingo"},
            {"Lovely", "Fire", "Fox"},
            {"Loyal", "Forest", "Giraffe"},
            {"Lucky", "Fuchsia", "Grasshopper"},
            {"Lyrical", "Gold", "Griffin"},
            {"Magical", "Gray", "Hamster"},
            {"Magnetic", "Green", "Hawk"},
            {"Majestic", "Indigo", "Hippogriff"},
            {"Marvelous", "Jade", "Hippopotamus"},
            {"Masterful", "Jungle", "Horse"},
            {"Mega", "Lava", "Inchworm"},
            {"Merry", "Lavender", "Kitten"},
            {"Metallic", "Lightning", "Kraken"},
            {"Micro", "Lime", "Lemur"},
            {"Mighty", "Magenta", "Leopard"},
            {"Mini", "Maroon", "Lion"},
            {"Mischievous", "Moonstone", "Lizard"},
            {"Muscular", "Mountain", "Manatee"},
            {"Musical", "Navy", "Monkey"},
            {"Mutant", "Ocean", "Narwhal"},
            {"Mysterious", "Olive", "Octopus"},
            {"Mythical", "Onyx", "Parrot"},
            {"Nice", "Opal", "Phoenix"},
            {"Nocturnal", "Orange", "Platypus"},
            {"Noticeable", "Pearl", "Pony"},
            {"Optimistic", "Pink", "Porcupine"},
            {"Outdoorsy", "Platinum", "Puppy"},
            {"Painted", "Plum", "Raccoon"},
            {"Patient", "Purple", "Rooster"},
            {"Peaceful", "Quartz", "Seahorse"},
            {"Perfect", "Rainforest", "Sloth"},
            {"Persistent", "Red", "Slug"},
            {"Pigmy", "River", "Snail"},
            {"Playful", "Ruby", "Sphinx"},
            {"Polite", "Sand", "Squid"},
            {"Powerful", "Sapphire", "Squirrel"},
            {"Quick", "Scarlet", "Stegosaurus"},
            {"Quiet", "Silver", "Tiger"},
            {"Quirky", "Sky", "Timberwolf"},
            {"Random", "Snow", "Tuna"},
            {"Remarkable", "Space", "Tyrannosaurus"},
            {"Righteous", "Tangerine", "Unicorn"},
            {"Robotic", "Teal", "Velociraptor"},
            {"Rockin'", "Titanium", "Walrus"},
            {"Rough", "Topaz", "Whale"},
            {"Round", "Violet", "Wolf"},
            {"Royal", "Yellow", "Zebra"},
            {"Running", "Amber", "Beaver"},
            {"Scaly", "Amethyst", "Bee"},
            {"Scary", "Apricot", "Canary"},
            {"Shadowy", "Arboreal", "Cat"},
            {"Shiny", "Arctic", "Catfish"},
            {"Shy", "Banana", "Centaur"},
            {"Singing", "Blue", "Chicken"},
            {"Skating", "Brass", "Coyote"},
            {"Skeptical", "Cave", "Cricket"},
            {"Skipping", "Celestial", "Dinosaur"},
            {"Sleepy", "Citrine", "Dog"},
            {"Slippery", "Cloud", "Dolphin"},
            {"Slow", "Cobalt", "Dragon"},
            {"Small", "Copper", "Dragonfly"},
            {"Smiling", "Crystal", "Eagle"},
            {"Sneezy", "Desert", "Elephant"},
            {"Soaring", "Diamond", "Falcon"},
            {"Soft", "Emerald", "Flamingo"},
            {"Sparkly", "Fire", "Fox"},
            {"Speckled", "Forest", "Giraffe"},
            {"Spikey", "Fuchsia", "Grasshopper"},
            {"Spirited", "Gold", "Griffin"},
            {"Splendid", "Gray", "Hamster"},
            {"Spooky", "Green", "Hawk"},
            {"Spotted", "Indigo", "Hippogriff"},
            {"Spunky", "Jade", "Hippopotamus"},
            {"Squeaky", "Jungle", "Horse"},
            {"Squishy", "Lava", "Inchworm"},
            {"Starry", "Lavender", "Kitten"},
            {"Stealthy", "Lightning", "Kraken"},
            {"Stellar", "Lime", "Lemur"},
            {"Stretchy", "Magenta", "Leopard"},
            {"Striped", "Maroon", "Lion"},
            {"Strong", "Moonstone", "Lizard"},
            {"Super", "Mountain", "Manatee"},
            {"Surprised", "Navy", "Monkey"},
            {"Swimming", "Ocean", "Narwhal"},
            {"Tall", "Olive", "Octopus"},
            {"Tame", "Onyx", "Parrot"},
            {"Terrific", "Opal", "Phoenix"},
            {"Thorny", "Orange", "Platypus"},
            {"Thundering", "Pearl", "Pony"},
            {"Ticklish", "Pink", "Porcupine"},
            {"Tiny", "Platinum", "Puppy"},
            {"Traveling", "Plum", "Raccoon"},
            {"Tremendous", "Purple", "Rooster"},
            {"Triumphant", "Quartz", "Seahorse"},
            {"Truthful", "Rainforest", "Sloth"},
            {"Twirling", "Red", "Slug"},
            {"Ultra", "River", "Snail"},
            {"Unbelievable", "Ruby", "Sphinx"},
            {"Velvety", "Sand", "Squid"},
            {"Visionary", "Sapphire", "Squirrel"},
            {"Vivacious", "Scarlet", "Stegosaurus"},
            {"Vivid", "Silver", "Tiger"},
            {"Vocal", "Sky", "Timberwolf"},
            {"Warm", "Snow", "Tuna"},
            {"Wild", "Space", "Tyrannosaurus"},
            {"Winged", "Tangerine", "Unicorn"},
            {"Wise", "Teal", "Velociraptor"},
            {"Witty", "Titanium", "Walrus"},
            {"Wonderful", "Topaz", "Whale"},
            {"Young", "Violet", "Wolf"},
            {"Zealous", "Yellow", "Zebra"}
    };

    /**
     * Array of initials to avoid. If the chosen 3 word name will produce any of
     * these initials, it is rejected and another is assigned.
     */
    private static List<String> blackList = new ArrayList<>(Arrays.asList(
            "ANL",
            "ANS",
            "ASS",
            "AZN",
            "BCH",
            "CAC",
            "CAK",
            "CAQ",
            "CLT",
            "CNT",
            "COC",
            "COK",
            "COQ",
            "CUM",
            "DCK",
            "DIC",
            "DIK",
            "DIQ",
            "DIX",
            "DMN",
            "DSH",
            "DYC",
            "DYK",
            "DYQ",
            "FAG",
            "FAP",
            "FCK",
            "FCU",
            "FGT",
            "FKU",
            "FOB",
            "FQU",
            "FTP",
            "FUC",
            "FUK",
            "FUQ",
            "FUX",
            "GAI",
            "GAY",
            "GEI",
            "GEY",
            "GIZ",
            "GUC",
            "GUK",
            "GUQ",
            "GVR",
            "GZZ",
            "HOR",
            "JAP",
            "JEW",
            "JIZ",
            "JOO",
            "JYZ",
            "JZZ",
            "KAC",
            "KAK",
            "KAQ",
            "KIK",
            "KKK",
            "KLT",
            "KNT",
            "KOC",
            "KOK",
            "KOQ",
            "KOX",
            "KUM",
            "KYC",
            "KYK",
            "KYQ",
            "LCK",
            "LIC",
            "LIK",
            "LIQ",
            "LOL",
            "LSD",
            "MFF",
            "MIC",
            "MIK",
            "MIQ",
            "MLF",
            "MUF",
            "MYC",
            "MYK",
            "MYQ",
            "NAD",
            "NDS",
            "NDZ",
            "NGR",
            "NIG",
            "NUT",
            "NWA",
            "ORL",
            "OPP",
            "PCP",
            "PHC",
            "PHK",
            "PHQ",
            "PIS",
            "PMS",
            "PNS",
            "POO",
            "POT",
            "PRC",
            "PRK",
            "PRN",
            "PRQ",
            "PSS",
            "PSY",
            "PUS",
            "RAC",
            "RAK",
            "RAQ",
            "RCK",
            "SAC",
            "SAK",
            "SAQ",
            "SCK",
            "SEX",
            "SFU",
            "SHT",
            "SJV",
            "SLT",
            "SNM",
            "SOB",
            "SOL",
            "STD",
            "SUC",
            "SUK",
            "SUQ",
            "SXE",
            "SXI",
            "SXX",
            "SXY",
            "THC",
            "TIT",
            "TOC",
            "TOK",
            "TOQ",
            "TWT",
            "VAG",
            "VAJ",
            "VGN",
            "VJN",
            "WAC",
            "WAK",
            "WAQ",
            "WCK",
            "WOP",
            "WTF",
            "XTC",
            "XXX",
            "AZS",
            "AZZ"));

    private FancyNames() {}

    public static String getDeviceFancyName(String devName) {
        String fancyName = null;
        if ((devName.startsWith("HB")) || (devName.startsWith("MB")) || (devName.startsWith("BB")) || (devName.startsWith("FN"))){
            LOG.debug("Code: {}" , devName.substring(2));

            int numberInDec = Integer.parseInt(devName.substring(2), 16);
            int mod16 = numberInDec%16;
            int top8 = numberInDec%256  ;
            int mid6 = (numberInDec/256)%64;
            int bot6 = (numberInDec/256)/64;

            int first = top8+mod16;
            int second = mid6+mod16;
            int third = bot6+mod16;

            fancyName = names[first][0]+" "+ names[second][1]+" "+ names[third][2];
            String initials = Character.toString(names[first][0].charAt(0)) + Character.toString(names[second][1].charAt(0)) + Character.toString(names[third][2].charAt(0));

            //iterate until not a bad word
            while (blackList.contains(initials)) {
                LOG.info("Found bad word: {} in {}", initials, fancyName);
                // add 1 and mod the result by 512 to the index of the second word:
                second++;
                second %= 512;
                fancyName = names[first][0]+" "+ names[second][1]+" "+ names[third][2];
                initials = Character.toString(names[first][0].charAt(0)) + Character.toString(names[second][1].charAt(0)) + Character.toString(names[third][2].charAt(0));

            }

            fancyName += " (" + initials + ")";
            LOG.debug("Fancy Name assigned to device: {}" , fancyName);
        }

        return fancyName;
    }
}
