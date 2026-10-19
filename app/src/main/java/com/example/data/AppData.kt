package com.example.data

import com.example.model.BibleVerseItem
import com.example.model.ColorLesson
import com.example.model.ParentGuideSection
import com.example.model.PrayerItem
import com.example.model.QuizQuestion

object AppData {

    val lessons = listOf(
        ColorLesson(
            id = "gold",
            colorName = "Gold",
            hexColor = "#F6C945",
            title = "God's Glory and Heaven",
            meaning = "Gold reminds us of God's glory, His perfect kingdom, and the wonderful hope of eternal life through Jesus Christ.",
            explanation = "God is holy, loving, and wonderful. The Bible tells us about His kingdom and His promise of eternal life. Through Jesus, we can know God and receive His gift of life.",
            verses = listOf(
                BibleVerseItem(
                    reference = "Revelation 21:21",
                    text = "And the twelve gates were twelve pearls; every several gate was of one pearl: and the street of the city was pure gold, as it were transparent glass.",
                    colorId = "gold"
                ),
                BibleVerseItem(
                    reference = "John 14:2",
                    text = "In my Father's house are many mansions: if it were not so, I would have told you. I go to prepare a place for you.",
                    colorId = "gold"
                ),
                BibleVerseItem(
                    reference = "Romans 6:23",
                    text = "For the wages of sin is death; but the gift of God is eternal life through Jesus Christ our Lord.",
                    colorId = "gold"
                )
            ),
            practicalApplication = "Remember that God loves you and offers eternal life through Jesus. You can thank Him for His promises.",
            prayer = "Dear God, thank You for Your wonderful promises and for loving me. Help me learn more about You and follow Jesus every day. Amen.",
            rememberThis = "God gives eternal life through Jesus Christ.",
            iconResName = "ic_gold"
        ),
        ColorLesson(
            id = "black",
            colorName = "Black",
            hexColor = "#30313A",
            title = "Our Need for Forgiveness",
            meaning = "Black represents sin and our need for forgiveness and reconciliation with God.",
            explanation = "Sin means disobeying God and choosing what is wrong. Everyone has sinned. But God loves us, and He offers forgiveness through Jesus Christ.",
            verses = listOf(
                BibleVerseItem(
                    reference = "Romans 3:23",
                    text = "For all have sinned, and come short of the glory of God;",
                    colorId = "black"
                ),
                BibleVerseItem(
                    reference = "Romans 6:23",
                    text = "For the wages of sin is death; but the gift of God is eternal life through Jesus Christ our Lord.",
                    colorId = "black"
                ),
                BibleVerseItem(
                    reference = "1 John 1:9",
                    text = "If we confess our sins, he is faithful and just to forgive us our sins, and to cleanse us from all unrighteousness.",
                    colorId = "black"
                )
            ),
            practicalApplication = "When you do something wrong, tell the truth, ask God for forgiveness, and try to make things right with anyone you have hurt.",
            prayer = "Dear God, I know that I sometimes make wrong choices. Please forgive me and help me choose what is right. Thank You for loving me. Amen.",
            rememberThis = "God loves us and offers forgiveness.",
            iconResName = "ic_black"
        ),
        ColorLesson(
            id = "red",
            colorName = "Red",
            hexColor = "#E84C4F",
            title = "Jesus' Love and Sacrifice",
            meaning = "Red reminds us of Jesus' sacrifice on the cross and His great love for us.",
            explanation = "Jesus loves us so much that He died on the cross for our sins and rose again. Through Jesus, we can receive God's forgiveness and begin a new life with Him.",
            verses = listOf(
                BibleVerseItem(
                    reference = "John 3:16",
                    text = "For God so loved the world, that he gave his only begotten Son, that whosoever believeth in him should not perish, but have everlasting life.",
                    colorId = "red"
                ),
                BibleVerseItem(
                    reference = "Romans 5:8",
                    text = "But God commendeth his love toward us, in that, while we were yet sinners, Christ died for us.",
                    colorId = "red"
                ),
                BibleVerseItem(
                    reference = "1 Corinthians 15:3-4",
                    text = "For I delivered unto you first of all that which I also received, how that Christ died for our sins according to the scriptures; And that he was buried, and that he rose again the third day according to the scriptures:",
                    colorId = "red"
                )
            ),
            practicalApplication = "Remember Jesus' love for you. Trust Him, thank Him, and show love to others.",
            prayer = "Lord Jesus, thank You for loving me, dying for my sins, and rising again. Help me trust You and follow Your Word. Amen.",
            rememberThis = "Jesus loves us and gave His life for us.",
            iconResName = "ic_red"
        ),
        ColorLesson(
            id = "white",
            colorName = "White",
            hexColor = "#FAFAFA",
            title = "Forgiveness and a Clean Heart",
            meaning = "White represents forgiveness, cleansing from sin, and the new life God gives through Jesus.",
            explanation = "When we turn to God and trust in Jesus, God forgives us and makes us new. He helps us grow in love, honesty, kindness, and obedience.",
            verses = listOf(
                BibleVerseItem(
                    reference = "Isaiah 1:18",
                    text = "Come now, and let us reason together, saith the LORD: though your sins be as scarlet, they shall be as white as snow; though they be red like crimson, they shall be as wool.",
                    colorId = "white"
                ),
                BibleVerseItem(
                    reference = "Psalm 51:10",
                    text = "Create in me a clean heart, O God; and renew a right spirit within me.",
                    colorId = "white"
                ),
                BibleVerseItem(
                    reference = "1 John 1:9",
                    text = "If we confess our sins, he is faithful and just to forgive us our sins, and to cleanse us from all unrighteousness.",
                    colorId = "white"
                )
            ),
            practicalApplication = "Tell the truth, forgive others, and ask for forgiveness when you make mistakes.",
            prayer = "Dear God, thank You for forgiving me. Give me a clean heart and help me become more loving, honest, and kind. Amen.",
            rememberThis = "God forgives us and helps us grow.",
            iconResName = "ic_white"
        ),
        ColorLesson(
            id = "green",
            colorName = "Green",
            hexColor = "#43A66C",
            title = "Growing in Faith",
            meaning = "Green represents new life and spiritual growth.",
            explanation = "Just as a plant needs water and sunlight, our faith grows when we learn God's Word, pray, trust Him, and show love to others.",
            verses = listOf(
                BibleVerseItem(
                    reference = "2 Peter 3:18",
                    text = "But grow in grace, and in the knowledge of our Lord and Saviour Jesus Christ. To him be glory both now and for ever. Amen.",
                    colorId = "green"
                ),
                BibleVerseItem(
                    reference = "Psalm 1:2-3",
                    text = "But his delight is in the law of the LORD; and in his law doth he meditate day and night. And he shall be like a tree planted by the rivers of water, that bringeth forth his fruit in his season; his leaf also shall not wither; and whatsoever he doeth shall prosper.",
                    colorId = "green"
                ),
                BibleVerseItem(
                    reference = "Galatians 5:22-23",
                    text = "But the fruit of the Spirit is love, joy, peace, longsuffering, gentleness, goodness, faith, Meekness, temperance: against such there is no law.",
                    colorId = "green"
                )
            ),
            practicalApplication = "Learn one Bible verse, pray, help someone, or practice kindness every day.",
            prayer = "Dear God, help my faith grow stronger every day. Teach me to love others, follow Your Word, and show the fruit of Your Spirit. Amen.",
            rememberThis = "We can grow in faith every day.",
            iconResName = "ic_green"
        ),
        ColorLesson(
            id = "blue",
            colorName = "Blue",
            hexColor = "#4C91E2",
            title = "Trusting God and Following Jesus",
            meaning = "Blue is an additional teaching color used in this app to represent faith, trust, hope, and following Jesus.",
            explanation = "We cannot always know what will happen next, but we can trust God and follow Jesus. We can pray, read the Bible, and ask God to help us make wise choices.",
            verses = listOf(
                BibleVerseItem(
                    reference = "Proverbs 3:5-6",
                    text = "Trust in the LORD with all thine heart; and lean not unto thine own understanding. In all thy ways acknowledge him, and he shall direct thy paths.",
                    colorId = "blue"
                ),
                BibleVerseItem(
                    reference = "Hebrews 11:1",
                    text = "Now faith is the substance of things hoped for, the evidence of things not seen.",
                    colorId = "blue"
                ),
                BibleVerseItem(
                    reference = "John 14:6",
                    text = "Jesus saith unto him, I am the way, the truth, and the life: no man cometh unto the Father, but by me.",
                    colorId = "blue"
                )
            ),
            practicalApplication = "When you feel worried or need help making a choice, pray, remember God's Word, and talk to a trusted parent or responsible adult.",
            prayer = "Dear God, help me trust You even when I do not understand everything. Guide my choices and help me follow Jesus. Amen.",
            rememberThis = "We can trust God and follow Jesus.",
            iconResName = "ic_blue"
        )
    )

    val allVerses = lessons.flatMap { it.verses }

    val quizQuestions = listOf(
        // Gold (5 questions)
        QuizQuestion(
            id = 1,
            colorId = "gold",
            questionText = "What does the color gold remind us of?",
            options = listOf(
                "God's glory and eternal life",
                "Having lots of pocket money",
                "Winning sports trophies",
                "Shiny gold coins"
            ),
            correctAnswerIndex = 0,
            explanation = "Gold reminds us of God's wonderful glory, His perfect kingdom, and eternal life through Jesus Christ."
        ),
        QuizQuestion(
            id = 2,
            colorId = "gold",
            questionText = "According to John 14:2, what has Jesus gone to prepare for us?",
            options = listOf(
                "A fancy amusement park",
                "Mansions in His Father's house",
                "A large golden castle",
                "A quiet garden"
            ),
            correctAnswerIndex = 1,
            explanation = "Jesus said: In my Father's house are many mansions... I go to prepare a place for you."
        ),
        QuizQuestion(
            id = 3,
            colorId = "gold",
            questionText = "What is the gift of God through Jesus Christ our Lord (Romans 6:23)?",
            options = listOf(
                "Eternal life",
                "A new bicycle",
                "Endless candy",
                "Famous toys"
            ),
            correctAnswerIndex = 0,
            explanation = "The Bible tells us that the gift of God is eternal life through Jesus Christ our Lord."
        ),
        QuizQuestion(
            id = 4,
            colorId = "gold",
            questionText = "Can we earn a place in heaven by good behavior or money?",
            options = listOf(
                "Yes, if we pay enough",
                "No, eternal life is God's free gift through Jesus",
                "Yes, if we never make mistakes",
                "Only on special holidays"
            ),
            correctAnswerIndex = 1,
            explanation = "Eternal life is a wonderful gift from God given through Jesus Christ, not something we can buy or earn."
        ),
        QuizQuestion(
            id = 5,
            colorId = "gold",
            questionText = "How can we respond to God's wonderful promise of eternal life?",
            options = listOf(
                "By thanking Him and following Jesus",
                "By keeping it a secret",
                "By ignoring it",
                "By worrying"
            ),
            correctAnswerIndex = 0,
            explanation = "We can thank God for His amazing love and promises, and follow Jesus every day."
        ),

        // Black (5 questions)
        QuizQuestion(
            id = 6,
            colorId = "black",
            questionText = "What does the color black represent in our lessons?",
            options = listOf(
                "Nighttime stars",
                "Sin and our need for forgiveness",
                "Cool winter clothes",
                "Shadows in the woods"
            ),
            correctAnswerIndex = 1,
            explanation = "Black represents sin—disobeying God and choosing what is wrong—and our need for forgiveness."
        ),
        QuizQuestion(
            id = 7,
            colorId = "black",
            questionText = "According to Romans 3:23, who has sinned?",
            options = listOf(
                "Only adults",
                "Only bad people",
                "All people have sinned and come short of God's glory",
                "Nobody today"
            ),
            correctAnswerIndex = 2,
            explanation = "The Bible says: For all have sinned, and come short of the glory of God."
        ),
        QuizQuestion(
            id = 8,
            colorId = "black",
            questionText = "What should we do when we make a wrong choice?",
            options = listOf(
                "Hide it from everyone",
                "Blame someone else",
                "Tell the truth, ask God for forgiveness, and make things right",
                "Pretend nothing happened"
            ),
            correctAnswerIndex = 2,
            explanation = "When we do something wrong, we should be honest, ask God for forgiveness, and make things right."
        ),
        QuizQuestion(
            id = 9,
            colorId = "black",
            questionText = "According to 1 John 1:9, what does God do when we confess our sins?",
            options = listOf(
                "He is faithful and just to forgive us and cleanse us",
                "He puts us in time-out",
                "He ignores us",
                "He takes away our toys"
            ),
            correctAnswerIndex = 0,
            explanation = "God is faithful and just to forgive us our sins and cleanse us from all unrighteousness."
        ),
        QuizQuestion(
            id = 10,
            colorId = "black",
            questionText = "Does sin make us worthless or beyond God's love?",
            options = listOf(
                "Yes, God stops loving us",
                "No, God loves us deeply and offers forgiveness",
                "Only sometimes",
                "Only on weekends"
            ),
            correctAnswerIndex = 1,
            explanation = "Never! God loves us so much and always offers forgiveness and restoration through Jesus."
        ),

        // Red (5 questions)
        QuizQuestion(
            id = 11,
            colorId = "red",
            questionText = "What does the color red remind us of?",
            options = listOf(
                "Jesus' love and sacrifice on the cross",
                "Red apples on a tree",
                "A fast race car",
                "A painted bedroom wall"
            ),
            correctAnswerIndex = 0,
            explanation = "Red reminds us of Jesus' great love and His sacrifice on the cross for our sins."
        ),
        QuizQuestion(
            id = 12,
            colorId = "red",
            questionText = "According to John 3:16, why did God give His only begotten Son?",
            options = listOf(
                "So whosoever believeth in Him should not perish but have everlasting life",
                "To win a contest",
                "To build a big house",
                "To travel the world"
            ),
            correctAnswerIndex = 0,
            explanation = "For God so loved the world, that he gave his only begotten Son, that whosoever believeth in him should not perish, but have everlasting life."
        ),
        QuizQuestion(
            id = 13,
            colorId = "red",
            questionText = "While we were yet sinners, what did Christ do for us (Romans 5:8)?",
            options = listOf(
                "He waited for us to be perfect",
                "Christ died for us",
                "He watched us from afar",
                "He left us alone"
            ),
            correctAnswerIndex = 1,
            explanation = "God commends His love toward us in that while we were yet sinners, Christ died for us."
        ),
        QuizQuestion(
            id = 14,
            colorId = "red",
            questionText = "What happened on the third day after Jesus was crucified?",
            options = listOf(
                "He rose again from the dead",
                "Nothing happened",
                "It started raining",
                "He moved to another city"
            ),
            correctAnswerIndex = 0,
            explanation = "According to the scriptures, Christ died for our sins, was buried, and rose again the third day."
        ),
        QuizQuestion(
            id = 15,
            colorId = "red",
            questionText = "How should we respond to Jesus' sacrifice?",
            options = listOf(
                "Trust Him, thank Him, and show love to others",
                "Forget about it",
                "Keep it to ourselves",
                "Be afraid"
            ),
            correctAnswerIndex = 0,
            explanation = "We can trust Jesus, thank Him for His great love, and share His love with everyone around us."
        ),

        // White (5 questions)
        QuizQuestion(
            id = 16,
            colorId = "white",
            questionText = "What does white represent?",
            options = listOf(
                "Fluffy clouds",
                "Forgiveness, cleansing from sin, and a clean heart",
                "Winter snow sports",
                "Blank paper"
            ),
            correctAnswerIndex = 1,
            explanation = "White represents forgiveness, being cleansed from sin, and the new life God gives through Jesus."
        ),
        QuizQuestion(
            id = 17,
            colorId = "white",
            questionText = "According to Isaiah 1:18, even though our sins are like scarlet, what can they become?",
            options = listOf(
                "As white as snow",
                "As bright as yellow",
                "As dark as night",
                "As green as grass"
            ),
            correctAnswerIndex = 0,
            explanation = "Though your sins be as scarlet, they shall be as white as snow."
        ),
        QuizQuestion(
            id = 18,
            colorId = "white",
            questionText = "What does King David pray in Psalm 51:10?",
            options = listOf(
                "Create in me a clean heart, O God",
                "Make me rich and famous",
                "Build me a palace",
                "Give me a crown"
            ),
            correctAnswerIndex = 0,
            explanation = "Psalm 51:10 says: Create in me a clean heart, O God; and renew a right spirit within me."
        ),
        QuizQuestion(
            id = 19,
            colorId = "white",
            questionText = "What does God help us grow in when our hearts are made clean?",
            options = listOf(
                "Love, honesty, kindness, and obedience",
                "Stubbornness",
                "Complaining",
                "Boasting"
            ),
            correctAnswerIndex = 0,
            explanation = "God helps us grow in love, honesty, kindness, and obedience as we walk with Him."
        ),
        QuizQuestion(
            id = 20,
            colorId = "white",
            questionText = "What is a practical way to show a clean heart?",
            options = listOf(
                "Tell the truth and forgive others",
                "Hold grudges",
                "Blame your friends",
                "Hide your mistakes"
            ),
            correctAnswerIndex = 0,
            explanation = "Telling the truth, forgiving others, and asking for forgiveness when we make mistakes shows a clean heart."
        ),

        // Green (5 questions)
        QuizQuestion(
            id = 21,
            colorId = "green",
            questionText = "What does the color green represent?",
            options = listOf(
                "Growing plants and financial wealth",
                "Spiritual growth and new life in Christ",
                "Traffic lights",
                "Green vegetables for dinner"
            ),
            correctAnswerIndex = 1,
            explanation = "Green represents new life and growing stronger in our faith and walk with God."
        ),
        QuizQuestion(
            id = 22,
            colorId = "green",
            questionText = "What does 2 Peter 3:18 tell us to do?",
            options = listOf(
                "Grow in grace, and in the knowledge of our Lord and Saviour Jesus Christ",
                "Plant a large garden",
                "Travel across the sea",
                "Build a tall tower"
            ),
            correctAnswerIndex = 0,
            explanation = "The Bible commands: But grow in grace, and in the knowledge of our Lord and Saviour Jesus Christ."
        ),
        QuizQuestion(
            id = 23,
            colorId = "green",
            questionText = "According to Psalm 1:2-3, where is a person like a tree planted?",
            options = listOf(
                "By the rivers of water",
                "In a dry desert",
                "On a rocky mountain",
                "Inside a house"
            ),
            correctAnswerIndex = 0,
            explanation = "He shall be like a tree planted by the rivers of water, that bringeth forth his fruit in his season."
        ),
        QuizQuestion(
            id = 24,
            colorId = "green",
            questionText = "What are some examples of the fruit of the Spirit (Galatians 5:22-23)?",
            options = listOf(
                "Love, joy, peace, longsuffering, gentleness, goodness, and faith",
                "Anger, pride, and impatience",
                "Speed, strength, and power",
                "Money, fame, and luxury"
            ),
            correctAnswerIndex = 0,
            explanation = "The fruit of the Spirit is love, joy, peace, longsuffering, gentleness, goodness, faith, meekness, and temperance."
        ),
        QuizQuestion(
            id = 25,
            colorId = "green",
            questionText = "How can we help our faith grow every day?",
            options = listOf(
                "Learn Bible verses, pray, and show kindness",
                "Sleep all day",
                "Play video games",
                "Watch television"
            ),
            correctAnswerIndex = 0,
            explanation = "Our faith grows when we learn God's Word, pray, trust Him, and practice kindness."
        ),

        // Blue (5 questions)
        QuizQuestion(
            id = 26,
            colorId = "blue",
            questionText = "What does blue represent in our lessons?",
            options = listOf(
                "The ocean waves",
                "Faith, trust, hope, and following Jesus",
                "The winter cold",
                "A clear swimming pool"
            ),
            correctAnswerIndex = 1,
            explanation = "Blue represents trusting God, having faith, and following Jesus in our daily lives."
        ),
        QuizQuestion(
            id = 27,
            colorId = "blue",
            questionText = "According to Proverbs 3:5-6, how should we trust in the LORD?",
            options = listOf(
                "With all thine heart",
                "Only when things are easy",
                "Just a little bit",
                "Only on Sundays"
            ),
            correctAnswerIndex = 0,
            explanation = "Trust in the LORD with all thine heart; and lean not unto thine own understanding."
        ),
        QuizQuestion(
            id = 28,
            colorId = "blue",
            questionText = "What does Hebrews 11:1 say that faith is?",
            options = listOf(
                "The substance of things hoped for, the evidence of things not seen",
                "Knowing everything in advance",
                "Having proof of science",
                "Wishing upon a star"
            ),
            correctAnswerIndex = 0,
            explanation = "Now faith is the substance of things hoped for, the evidence of things not seen."
        ),
        QuizQuestion(
            id = 29,
            colorId = "blue",
            questionText = "According to John 14:6, who is the way, the truth, and the life?",
            options = listOf(
                "Jesus",
                "An angel",
                "A prophet",
                "A king"
            ),
            correctAnswerIndex = 0,
            explanation = "Jesus saith unto him, I am the way, the truth, and the life: no man cometh unto the Father, but by me."
        ),
        QuizQuestion(
            id = 30,
            colorId = "blue",
            questionText = "What should you do when you feel worried or need help making a choice?",
            options = listOf(
                "Pray, remember God's Word, and talk to a trusted parent or adult",
                "Keep it all to yourself",
                "Run away",
                "Get angry"
            ),
            correctAnswerIndex = 0,
            explanation = "When worried or needing guidance, we can pray, rely on God's Word, and talk to a trusted parent or adult."
        )
    )

    val prayers = listOf(
        PrayerItem(
            id = "morning",
            title = "Morning Prayer",
            prayerText = "Dear God, thank You for giving me a brand new day! Help me to love You, obey Your word, and be kind to everyone I meet today. Guide my steps and keep me safe. In Jesus' name, Amen.",
            bibleReference = "Psalm 118:24"
        ),
        PrayerItem(
            id = "evening",
            title = "Evening Prayer",
            prayerText = "Dear Heavenly Father, thank You for watching over me all through today. Please forgive me for any wrong choices I made. Give me sweet, peaceful sleep and wake me up refreshed tomorrow. Amen.",
            bibleReference = "Psalm 4:8"
        ),
        PrayerItem(
            id = "wisdom",
            title = "Prayer for Wisdom",
            prayerText = "Lord God, please give me wisdom to know what is right and the courage to choose it. Help me to learn Your Word and understand Your ways. Amen.",
            bibleReference = "James 1:5"
        ),
        PrayerItem(
            id = "forgiveness",
            title = "Prayer for Forgiveness",
            prayerText = "Dear God, I am sorry for when I disobey You or hurt others. Thank You for loving me and forgiving me through Jesus. Help me also to forgive those who hurt me. Amen.",
            bibleReference = "1 John 1:9"
        ),
        PrayerItem(
            id = "family",
            title = "Prayer for Family",
            prayerText = "Dear Jesus, bless my family with peace, health, and love. Help us to care for each other, share, and honor You in our home every day. Amen.",
            bibleReference = "Joshua 24:15"
        ),
        PrayerItem(
            id = "friends",
            title = "Prayer for Friends",
            prayerText = "Dear God, thank You for my friends. Bless them and their families. Help me to be a good friend who is kind, honest, and helpful. Amen.",
            bibleReference = "Proverbs 17:17"
        ),
        PrayerItem(
            id = "courage",
            title = "Prayer for Courage",
            prayerText = "Lord, when I feel scared or worried, remind me that You are always with me. Give me courage to do what is right and trust in Your strength. Amen.",
            bibleReference = "Joshua 1:9"
        ),
        PrayerItem(
            id = "thank_you",
            title = "Thank You, God Prayer",
            prayerText = "Thank You, God, for my life, my family, food, and clothes. Most of all, thank You for sending Jesus to save me and give me eternal life. I love You, Lord! Amen.",
            bibleReference = "Psalm 107:1"
        )
    )

    val parentGuideSections = listOf(
        ParentGuideSection(
            title = "Introduction to the Colors of Salvation",
            content = "The Colors of Salvation (often called the Wordless Book) is a wonderful, time-tested teaching tool using simple colors to explain the Christian message of the Gospel to children. Each color represents a key biblical truth about God's love, our human condition, Christ's sacrifice, forgiveness, spiritual growth, and trust.",
            discussionQuestions = listOf(
                "What does this color teach us about God's character?",
                "Which Bible verse from today's lesson is your favorite?"
            )
        ),
        ParentGuideSection(
            title = "Explaining Sin and Forgiveness Gently",
            content = "When talking about sin (the black color), emphasize that everyone makes mistakes and falls short, but God loves us deeply. Avoid graphic descriptions or shaming language. The focus should quickly pivot to God's immense love and forgiveness through Jesus Christ (red and white colors).",
            discussionQuestions = listOf(
                "What does it mean when we make a wrong choice?",
                "How does God respond when we ask Him for forgiveness?"
            )
        ),
        ParentGuideSection(
            title = "Nurturing Spiritual Growth (Green & Blue)",
            content = "Spiritual growth happens gradually, just like a plant growing from a seedling. Encourage daily habits such as reading short Bible verses, praying together as a family, showing kindness, and trusting God during difficult moments.",
            discussionQuestions = listOf(
                "How can we show God's love to someone today?",
                "What is one thing you can talk to God about in prayer right now?"
            )
        ),
        ParentGuideSection(
            title = "Family Devotion Ideas",
            content = "Use this app during family devotional time or before bedtime. Review one color per week, memorize the key verse together, take the quiz as a fun family game, and practice the suggested prayer.",
            discussionQuestions = listOf(
                "What would you like to thank God for today?",
                "How can our family follow Jesus better this week?"
            )
        )
    )
}
