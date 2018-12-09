package by.mogyjib.guitarnotes.utils

import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.utils.extentions.rand


val songNamesList = names().split("\n")
val songAuthorsList = authors().split("\n")

fun fakeSongList(): List<Song> {
    val songs = mutableListOf<Song>()
    val authorsCount = songAuthorsList.size
    songNamesList.forEach {
        songs.add(Song(name = it,
                        author = songAuthorsList[(1..authorsCount).rand()-1],
                        text = randomText((30..70).rand()))
        )
    }
    return songs.toList()
}

private fun randomText(wordCount: Int = 100, wordSize: IntRange = 2..7): String {
    var result = ""
    var line = 1
    for (i in 0..wordCount) {
        result += randomString(wordSize.rand()) + " "
        if (line % (2..5).rand() == 0) {
            result += "\n"
            line = 0
        }
        line++
    }
    return result
}

private fun randomString(
        length: Int,
        charset: MutableList<Char> = mutableListOf<Char>().apply {
            addAll('a'..'z')
            addAll('A'..'Z')
        }
): String {
    var result = ""
    (0..length).forEach { result += charset[(1..charset.size).rand() - 1] }
    return result
}

private fun names() = "S.O.S.\n" +
        "Mamma Mia\n" +
        "Waterloo\n" +
        "I Do, I Do, I Do, I Do, I Do\n" +
        "Dancing Queen\n" +
        "Fernando\n" +
        "Gimme! Gimme! Gimme! (A Man After Midnight)\n" +
        "Does Your Mother Know\n" +
        "The Name Of The Game\n" +
        "Knowing Me, Knowing You\n" +
        "The Winner Takes It All\n" +
        "Poison Arrow\n" +
        "The Look of Love, Pt. 1\n" +
        "Be Near Me\n" +
        "Always Always\n" +
        "You Shook Me All Night Long\n" +
        "T.N.T.\n" +
        "Highway To Hell\n" +
        "Hells Bells\n" +
        "Back In Black\n" +
        "Rock and Roll Ain't Noise Pollution\n" +
        "Dirty Deeds Done Dirt Cheap\n" +
        "Whole Lotta Rosie\n" +
        "Let There Be Rock\n" +
        "*8368 Bear Claws\n" +
        "Princess Of The Dawn\n" +
        "How Long\n" +
        "Antmusic\n" +
        "Dog Eat Dog\n" +
        "Prince Charming\n" +
        "Stand and Deliver\n" +
        "Straight From The Heart\n" +
        "Summer Of '69\n" +
        "Desire\n" +
        "Two\n" +
        "New York, New York\n" +
        "Magick\n" +
        "Slow Dancin' Don't Turn Me On\n" +
        "Rolling in the Deep\n" +
        "Hello\n" +
        "Lovesong\n" +
        "New Kind of Cool\n" +
        "Broken Land\n" +
        "Gary Gilmore’s Eyes\n" +
        "Dream On\n" +
        "Janie's Got a Gun\n" +
        "Walk This Way\n" +
        "Pink\n" +
        "Dude (Looks Like a Lady)\n" +
        "Sweet Emotion\n" +
        "The Other Side\n" +
        "Rag Doll\n" +
        "What It Takes\n" +
        "Remember (Walking in the Sand)\n" +
        "Last Child\n" +
        "Same Old Song and Dance\n" +
        "Crazy\n" +
        "Back in the Saddle\n" +
        "Seasons of Wither\n" +
        "Livin' on the Edge\n" +
        "Cryin'\n" +
        "If I Were Going\n" +
        "Gentlemen\n" +
        "Demon In Profile\n" +
        "Debonair\n" +
        "Faded\n" +
        "Der Kommissar\n" +
        "Sink, Florida, Sink\n" +
        "Transgender Dysphoria Blues\n" +
        "Grace Like Rain\n" +
        "Gotta Go\n" +
        "Beautiful\n" +
        "Dream\n" +
        "Are We Different\n" +
        "Wallflower\n" +
        "Leave the Light On\n" +
        "Kelly Watch the Stars\n" +
        "La Femme d'Argent\n" +
        "Playground Love (Sung By Gordon Tracks)\n" +
        "Cherry Blossom Girl (Radio Edit)\n" +
        "Sexy Boy\n" +
        "All I Need\n" +
        "Sometime Around Midnight\n" +
        "Timeless\n" +
        "Wrong\n" +
        "All I Ever Wanted\n" +
        "Bride & Groom\n" +
        "The Storm\n" +
        "The Fifth Day\n" +
        "Hell And Back\n" +
        "Sober Up\n" +
        "Always Alright\n" +
        "Be Mine\n" +
        "Marching On\n" +
        "The Stand\n" +
        "Everyday Robots\n" +
        "Sick of Myself\n" +
        "I'm OK\n" +
        "I See Stars\n" +
        "Only Women Bleed\n" +
        "Clones (We're All)\n" +
        "I'm Eighteen\n" +
        "School's Out" //+
//        "Heaven Beside You\n" +
//        "Over Now\n" +
//        "Man In The Box\n" +
//        "Down In A Hole\n" +
//        "Would\n" +
//        "Gives You Hell\n" +
//        "Every Girl\n" +
//        "Had It All\n" +
//        "Busman's Holiday\n" +
//        "Catamaran\n" +
//        "Catalina\n" +
//        "\n" +
//        "The Fear\n" +
//        "Smile (Radio Edit)\n" +
//        "Whipping Post\n" +
//        "In Memory Of Elizabeth Reed\n" +
//        "Melissa\n" +
//        "Ain't Wastin' Time No More\n" +
//        "Blue Sky\n" +
//        "Midnight Rider\n" +
//        "Little Martha\n" +
//        "Statesboro Blues\n" +
//        "Dreams\n" +
//        "Jessica\n" +
//        "Ramblin' Man\n" +
//        "Crazy Love\n" +
//        "One Way Out\n" +
//        "Wasted Words\n" +
//        "Southbound\n" +
//        "Revival\n" +
//        "The Lonely Bull\n" +
//        "Tijuana Taxi\n" +
//        "A Handful Of Darkness\n" +
//        "Forever Young\n" +
//        "Hunger Of The Pine\n" +
//        "Breezeblocks\n" +
//        "Every Other Freckle\n" +
//        "Left Hand Free\n" +
//        "Tessellate\n" +
//        "In Cold Blood\n" +
//        "I Could Be Happy (Single Version)\n" +
//        "See Those Eyes (Single Version)\n" +
//        "Happy Birthday\n" +
//        "Archie, Marry Me\n" +
//        "Next Of Kin\n" +
//        "Party Police\n" +
//        "In Undertow\n" +
//        "*5236 Dreams Tonite\n" +
//        "Adult Diversion\n" +
//        "*7566 Not My Baby\n" +
//        "One More Night\n" +
//        "Journey To The Center Of The Mind\n" +
//        "Lonely People\n" +
//        "A Horse With No Name\n" +
//        "Tin Man\n" +
//        "Sister Golden Hair\n" +
//        "Don't Cross The River\n" +
//        "I Need You\n" +
//        "Sandman\n" +
//        "Daisy Jane\n" +
//        "Ventura Highway\n" +
//        "Hit It\n" +
//        "Bend Me Shape Me\n" +
//        "Over There (with Billy Murray) [Recorded 1917]\n" +
//        "Gravitational Pull\n" +
//        "Tear in Your Hand\n" +
//        "Cornflake Girl\n" +
//        "Raspberry Swirl\n" +
//        "Marianne\n" +
//        "Winter\n" +
//        "Precious Things\n" +
//        "A Sorta Fairytale\n" +
//        "Spark\n" +
//        "Horses\n" +
//        "Silent All These Years\n" +
//        "Angels\n" +
//        "Pretty Good Year (Live from Sound Check)\n" +
//        "Caught A Lite Sneeze\n" +
//        "God\n" +
//        "Bruised Reed\n" +
//        "Floating World\n" +
//        "Deep\n" +
//        "Fragile Dreams\n" +
//        "Time To Die\n" +
//        "Relative Ways\n" +
//        "Crash About To Happen\n" +
//        "Clowns\n" +
//        "Brother Of Mine - I) The Big Dream, II) Nothing Can Come Between Us, III) Long Lost Brother Of Mine\n" +
//        "O Superman (For Massenet)\n" +
//        "People II: The Reckoning\n" +
//        "Do-Re-Mi\n" +
//        "Stay Awake\n" +
//        "Boogie Woogie Bugle Boy\n" +
//        "My Boyfriend's Back\n" +
//        "Fireworks\n" +
//        "My Girls\n" +
//        "The Purple Bottle\n" +
//        "Grass\n" +
//        "Golden Gal\n" +
//        "Strange Attractor\n" +
//        "House Of The Rising Sun\n" +
//        "Don't Let Me Be Misunderstood\n" +
//        "It's My Life\n" +
//        "We Gotta Get Out Of This Place\n" +
//        "Bring It On Home To Me\n" +
//        "Bury My Body\n" +
//        "Sky Pilot\n" +
//        "Monterrey\n" +
//        "Gonna Send You Back To Walker\n" +
//        "Baby, Let MeTake You Home\n" +
//        "I'm Crying\n" +
//        "I'm In Love Again\n" +
//        "When I Was Young\n" +
//        "Talkin' Bout You\n" +
//        "Dimples\n" +
//        "Around And Around\n" +
//        "Boom Boom\n" +
//        "San Fransiscan Nights\n" +
//        "Help Me Girl\n" +
//        "Obsession\n" +
//        "My Heartbeat\n" +
//        "Desperate But Not Serious\n" +
//        "Goody Two Shoes\n" +
//        "Dirty Money\n" +
//        "French Exit\n" +
//        "Every Night My Teeth Are Falling Out\n" +
//        "Rolled Together\n" +
//        "In The Attic\n" +
//        "I Don't Want Love\n" +
//        "Kettering\n" +
//        "Sylvia\n" +
//        "Epilogue\n" +
//        "Palace\n" +
//        "Katie Queen of Tennessee\n" +
//        "Alberto Balsalm\n" +
//        "Windowlicker\n" +
//        "Fear of Heights\n" +
//        "Today Is the Day\n" +
//        "Singing To The Earth (To Thank Her For You)\n" +
//        "Sleep To Dream\n" +
//        "Criminal\n" +
//        "Shadowboxer\n" +
//        "Never Is A Promise\n" +
//        "Pale September\n" +
//        "Carrion\n" +
//        "I Want You (Live for Decades Rock Live!)\n" +
//        "Across the Universe\n" +
//        "Paper Bag\n" +
//        "Sullen Girl\n" +
//        "A Mistake\n" +
//        "Get Gone\n" +
//        "Get Him Back\n" +
//        "Love Ridden\n" +
//        "Please Please Please\n" +
//        "The Child Is Gone\n" +
//        "O' Sailor\n" +
//        "I Know\n" +
//        "The First Taste\n" +
//        "Window\n" +
//        "Energy\n" +
//        "Same Old Drag\n" +
//        "Tidal Wave\n" +
//        "Rainfall\n" +
//        "Tin Pan Alley\n" +
//        "Holiday Mood\n" +
//        "Barbie Girl\n" +
//        "Cartoon Heroes\n" +
//        "Time Moves Slow\n" +
//        "Brighter Than Sunshine\n" +
//        "False Spring\n" +
//        "Mohammed's Hex and Bounty\n" +
//        "Neighborhood #1 (Tunnels)\n" +
//        "Rebellion (Lies)\n" +
//        "Haiti\n" +
//        "Sprawl II (Mountains Beyond Mountains)\n" +
//        "Everything Now\n" +
//        "Keep the Car Running\n" +
//        "We Used to Wait\n" +
//        "The Suburbs\n" +
//        "Reflektor\n" +
//        "Neighborhood #2 (Laika)\n" +
//        "No Cars Go\n" +
//        "Intervention\n" +
//        "Creature Comfort\n" +
//        "The Well and the Lighthouse\n" +
//        "Wake Up\n" +
//        "Ready to Start\n" +
//        "Neighborhood #3 (Power Out)\n" +
//        "My Body Is A Cage\n" +
//        "Afterlife\n" +
//        "Abraham's Daughter\n" +
//        "Electric Blue\n" +
//        "Web In Front\n" +
//        "Lowest Part Is Free!\n" +
//        "Sugar Sugar\n" +
//        "Why'd You Only Call Me When You're High?\n" +
//        "Don't Sit Down 'cause I've Moved Your Chair\n" +
//        "You're So Dark\n" +
//        "No. 1 Party Anthem\n" +
//        "*5961 Red Light Indicates Doors Are Secure\n" +
//        "Piledriver Waltz\n" +
//        "She's Thunderstorms\n" +
//        "That's Where You're Wrong\n" +
//        "Black Treacle\n" +
//        "I Bet You Look Good On The Dancefloor\n" +
//        "Good Mother\n" +
//        "Insensitive\n" +
//        "Hold Your Head Up\n" +
//        "Liar\n" +
//        "Bright Lit Blue Skies\n" +
//        "Round and Round\n" +
//        "Seduction\n" +
//        "The Weakness in Me\n" +
//        "Love and Affection\n" +
//        "Make The World Go Away\n" +
//        "Good Morning City\n" +
//        "Sick and Beautiful\n" +
//        "Jailer\n" +
//        "Your Amazing Life\n" +
//        "Nothing Starts Today\n" +
//        "Casper's Coming Home\n" +
//        "Windy\n" +
//        "Six Man Band\n" +
//        "Never My Love\n" +
//        "Cherish\n" +
//        "Along Comes Mary\n" +
//        "L-L-Love\n" +
//        "The Way You Look Tonight\n" +
//        "Invalid Litter Dept.\n" +
//        "Maybe Tonight\n" +
//        "A Little Crazy\n" +
//        "So Into You\n" +
//        "Champagne Jam\n" +
//        "Spooky\n" +
//        "Doraville\n" +
//        "Imaginary Lover\n" +
//        "Molecules (Single Version)\n" +
//        "Walkabout (With Noah Lennox)\n" +
//        "Get Down\n" +
//        "Big House\n" +
//        "Hands and Feet\n" +
//        "Ocean Floor\n" +
//        "Doesn't Remind Me\n" +
//        "Be Yourself\n" +
//        "Like a Stone\n" +
//        "Waiting On A Song\n" +
//        "Shine On Me\n" +
//        "King Of A One Horse Town\n" +
//        "The Offer\n" +
//        "One Crowded Hour\n" +
//        "Five Foot Two, Eyes of Blue\n" +
//        "My Blue Heaven\n" +
//        "Bye Bye Blackbird\n" +
//        "Ain't She Sweet\n" +
//        "Eggshell\n" +
//        "\n" +
//        "VLetrmx21\n" +
//        "Altibzz\n" +
//        " Frontier Psychiatrist\n" +
//        "Frankie Sinatra (Extended Mix)\n" +
//        "Venus\n" +
//        "Pick Up The Pieces\n" +
//        "I and Love and You\n" +
//        "Head Full of Doubt / Road Full of Promise\n" +
//        "The Perfect Space\n" +
//        "Little Fang\n" +
//        "Wake Me Up\n" +
//        "I Feel It (Bonus Track)\n" +
//        "Sail\n" +
//        "Hollow Moon (Bad Wolf)\n" +
//        "Stranger In Blue Suede Shoes\n" +
//        "Lady Rachel\n" +
//        "Waking Dreams\n" +
//        "Epilogie: the Memory Remains (unreleased Track)\n" +
//        "Ride the Comet\n" +
//        "Carried By the Wind\n" +
//        "Oblivious\n" +
//        "Somewhere In My Heart\n" +
//        "Sleep\n" +
//        "Displaced\n" +
//        "Lonely By Your Side (Featuring Jonny Blake) [Radio Cut]\n" +
//        "The Beatles\n" +
//        "The BeatlesBa-Be\n" +
//        "Nut Rocker (Top Rank International)\n" +
//        "Dance This Mess Around\n" +
//        "Rock Lobster\n" +
//        "Lava\n" +
//        "There's A Moon In The Sky (Called The Moon)\n" +
//        "Hero Worship\n" +
//        "Funplex\n" +
//        "Love Shack\n" +
//        " Girls\n" +
//        "Roam\n" +
//        "-842\n" +
//        "Planet Claire\n" +
//        "Private Idaho\n" +
//        "High Heel Leather Boots "

private fun authors() = "ABBA\n" +
        "ABC\n" +
        "Abstracts\n" +
        "AC/DC\n" +
        "The Academic\n" +
        "Accept\n" +
        "Ace\n" +
        "Adam and The Ants\n" +
        "Bryan Adams\n" +
        "Ryan Adams\n" +
        "The Addrisi Brothers\n" +
        "ADELE\n" +
        "Adrianne\n" +
        "The Adventures\n" +
        "The Adverts\n" +
        "Aerosmith\n" +
        "The Afghan Whigs\n" +
        "After the Fire\n" +
        "Against Me!\n" +
        "Todd Agnew\n" +
        "Agnostic Front"// +
//        "Christina Aguilera\n" +
//        "Priscilla Ahn\n" +
//        "Air\n" +
//        "The Airborne Toxic Event\n" +
//        "AJR\n" +
//        "Alabama Shakes\n" +
//        "The Alarm (IRS)\n" +
//        "Damon Albarn\n" +
//        "Cindy Alexander\n" +
//        "Alice Cooper\n" +
//        "Alice in Chains\n" +
//        "The All-American Rejects\n" +
//        "Allah-Las\n" +
//        "Lily Allen\n" +
//        "The Allman Brothers Band\n" +
//        "Herb Alpert\n" +
//        "Alphaville\n" +
//        "Alt-J\n" +
//        "Altered Images\n" +
//        "Alvvays\n" +
//        "Amber\n" +
//        "The Amboy Dukes\n" +
//        "America\n" +
//        "American Authors\n" +
//        "American Breed\n" +
//        "American Quartet\n" +
//        "Bob Amos\n" +
//        "Tori Amos\n" +
//        "Anathallo\n" +
//        "Anathema\n" +
//        "Ancient Grease\n" +
//        "...And You Will Know Us By the Trail of Dead\n" +
//        "Brett Anderson\n" +
//        "Anderson Bruford Wakeman Howe\n" +
//        "Laurie Anderson\n" +
//        "Andrew Jackson Jihad\n" +
//        "Julie Andrews\n" +
//        "Andrews Sisters With Vic Schoen & His Orchestra\n" +
//        "The Angels\n" +
//        "Animal Collective\n" +
//        "Animal Kingdom\n" +
//        "The Animals\n" +
//        "Animotion\n" +
//        "Annie\n" +
//        "Adam Ant\n" +
//        "Antibalas\n" +
//        "The Antlers\n" +
//        "The Apache Relay\n" +
//        "Aphex Twin\n" +
//        "Apollo Sunshine\n" +
//        "Fiona Apple\n" +
//        "The Apples In Stereo\n" +
//        "Aqua\n" +
//        "Aqualung\n" +
//        "Arbouretum\n" +
//        "Arcade Fire\n" +
//        "Archers Of Loaf\n" +
//        "The Archies\n" +
//        "Arctic Monkeys\n" +
//        "Jann Arden\n" +
//        "Argent\n" +
//        "Ariel Pink's Haunted Graffiti\n" +
//        "Diane Arkenstone\n" +
//        "Joan Armatrading\n" +
//        "Eddy Arnold\n" +
//        "Arson Welles\n" +
//        "Artificial Joy Club\n" +
//        "Asa\n" +
//        "Ass Ponys\n" +
//        "The Association\n" +
//        "Astaire\n" +
//        "Astaire Fred\n" +
//        "At the Drive-In\n" +
//        "Nicole Atkins\n" +
//        "Atlanta Rhythm Section\n" +
//        "Atlas Genius\n" +
//        "Atlas Sound\n" +
//        "Audio Adrenaline\n" +
//        "Audioslave\n" +
//        "Dan Auerbach\n" +
//        "Augie March\n" +
//        "Gene Austin\n" +
//        "Gene Austin & Nat Shilkret & His Orchestra\n" +
//        "Autechre\n" +
//        "The Avalanches\n" +
//        "Frankie Avalon\n" +
//        "Average White Band\n" +
//        "The Avett Brothers\n" +
//        "Avey Tare's Slasher Flicks\n" +
//        "Avicii\n" +
//        "Avid Dancer\n" +
//        "Awolnation\n" +
//        "Kevin Ayers\n" +
//        "Ayreon\n" +
//        "Aztec Camera\n" +
//        "Azure Ray\n" +
//        "Azzido da Bass featuring Johnny Blake\n" +
//        "The BeatlesBa-Be\n" +
//        "B Bumble And The Stingers\n" +
//        "The B-52's\n" +
//        "Baby Bee"
