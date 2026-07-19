# FitTrack V3 feature rebuild

Added dedicated modules instead of reusing one generic form:

- Meal Tracker: Breakfast, Lunch, Evening Snack, Dinner; calories, protein, fiber, carbohydrates, fat, sugar and sodium; simple Healthy/Moderate/Unhealthy informational classification; daily totals and meal history.
- Water Tracker: per-entry and per-day hydration logging; quick-add buttons; progress ring; suggested baseline using approximately 35 ml/kg of latest body weight.
- Weight & BMI: current BMI, standard adult BMI category, and reference healthy-weight interval calculated from saved height.
- Workout Tracker: dedicated workout form for type, exercise, duration, sets and repetitions.
- Steps & Activity: dedicated activity overview.
- Progress Analytics: dedicated recent consistency overview.
- Professional page heroes, animated cards, hydration ring, responsive mobile layouts, dark mode compatibility.

Important health note:
BMI and hydration values are general informational estimates. BMI is a screening measure, and hydration needs vary with climate, activity, health conditions, pregnancy and clinician guidance.

Schema note:
If upgrading from an older local H2 database, new MealItem columns are added by Hibernate's local-development ddl-auto=update. Production should use explicit Flyway migrations.
