# Colors of Faith — Bible for Kids: Implementation Plan

A feature-rich, fully offline Christian children's Bible application teaching the message of salvation through the traditional Colors of Salvation (Gold, Black, Red, White, Green, Blue) concept with Jetpack Compose, Material 3, KJV Bible verses, interactive quizzes, learning progress tracking, prayer time, bookmarks, and parent-teacher guide.

## User Review & Critical Decisions

> [!IMPORTANT]
> - **Confirmed Choices**: Optional audio buttons for text-to-speech, immediate feedback with positive encouragement for quizzes, and warm cream background with vibrant multi-color accents.
> - **Offline First**: All lessons, verses, quizzes, and prayers are stored locally and work 100% offline in airplane mode.
> - **Zero External Backend / Login**: Fully self-contained local storage using Room or DataStore for progress, quiz scores, and bookmarks.

---

## 1. Overview & Core Concept

- **What It Does**: An engaging, child-friendly Christian Bible app for children ages 4–12. It guides young explorers through the 6 Colors of Salvation, offering interactive lessons, KJV scripture verses, quizzes with instant positive feedback, prayer cards, progress tracking, and bookmarking.
- **Target Audience**: Children, parents, and Sunday school teachers seeking wholesome, Bible-centered educational content.
- **Key Value**: 100% offline reliability, beautiful illustrated Christian visual identity (open Bible, cross, radiant light, colorful ribbons), positive reinforcement, and comprehensive offline scripture/prayer resources.

## 2. User Experience & Visual Design

- **Visual Identity**: Warm cream background (`#FFF9F0`), dark charcoal text (`#263238`), and vibrant color themes for each lesson (Gold `#F6C945`, Black `#30313A`, Red `#E84C4F`, White `#FFFFFF`, Green `#43A66C`, Blue `#4C91E2`).
- **Key Screens & Flows**:
  1. **Splash Screen**: Animated glowing Bible & cross with colorful gradient background (`#DFF3FF` to `#F6C945` & `#FF9F43`) transitioning smoothly to Home.
  2. **Home Screen**: Welcoming greeting ("Hello, Little Bible Explorer!"), 6 main cards (Learn Colors, Bible Verses, Color Quiz, Learning Journey, Prayer Time, Parents & Teachers), and quick footer.
  3. **Learn the Colors (List & Detail)**: Grid of 6 color lessons with icons, progress indicators, and rich detail screens featuring KJV verses, practical applications, prayers, "Remember This" takeaways, and bookmarking.
  4. **Bible Verse Library**: Searchable collection of all KJV verses organized by color/lesson with copy, bookmark, and optional TTS read-aloud buttons.
  5. **Multiple-Choice Quiz**: 30 questions (5 per color) with 4 choices, immediate positive feedback, score tracking, best score persistence, and completion badges.
  6. **My Learning Journey**: Visual progress tracker showing completed lessons, earned stars, quiz scores, and completion badge.
  7. **Prayer Time**: Collection of 8 child-friendly prayers (Morning, Evening, Wisdom, Forgiveness, Family, Friends, Courage, Thank You) with TTS support.
  8. **Parents & Teachers Guide**: Practical tips, discussion questions, devotion ideas, and guidance on explaining salvation gently.
  9. **Favorites / Bookmarks & About / Privacy**: Manage saved lessons/verses/prayers and view offline privacy details.

## 3. Key Product Decisions & Trade-Offs

- **Local Storage**: Use `SharedPreferences` / `DataStore` or lightweight Room database for saving bookmarks, quiz scores, and completed lessons locally and reliably across app restarts.
- **Text-to-Speech (TTS)**: Uses Android's built-In `TextToSpeech` engine with robust null checks and graceful fallbacks if speech data is unavailable.
- **Offline Assets**: All illustrations, icons, and text data are bundled locally in resources and Kotlin data classes.

## 4. Technical Architecture & Data Strategy

```
┌────────────────────────────────────────────────────────┐
│                        UI Layer                        │
│ (Jetpack Compose, Material 3, Navigation Compose)       │
└──────────────────────────┬─────────────────────────────┘
                           │
┌──────────────────────────▼─────────────────────────────┐
│                      ViewModel                         │
│       (StateFlow / UI State / Business Logic)          │
└──────────────────────────┬─────────────────────────────┘
                           │
┌──────────────────────────▼─────────────────────────────┐
│                   Local Repository                     │
│         (DataStore / SharedPreferences / JSON)         │
└────────────────────────────────────────────────────────┘
```

- **Data Models**: `ColorLesson`, `BibleVerse`, `QuizQuestion`, `Prayer`, `UserProgress`, `Bookmark`.
- **Navigation**: Type-safe routes or string routes with `NavHost`, bottom navigation bar, and Android back button handling.
- **Accessibility & Safe Areas**: Edge-to-edge support with proper window inset handling and 48dp minimum touch targets.
