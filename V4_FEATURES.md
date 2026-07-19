# FitTrack Java V4

Major additions:
- ADMIN role and protected Admin Console
- Registered user count, 7-day registration trend and user directory
- Admin console intentionally does not expose private health records
- Body-weight trend data API and existing Chart.js trend visualization
- Automatic steps -> estimated distance using height-based stride estimate
- Automatic steps/distance -> estimated walking calories using current weight
- Health Connect-provided distance/calorie values take priority when supplied
- Automatic local food nutrition lookup: user selects food + quantity; calories/macros are calculated server-side
- Dedicated meals: breakfast, lunch, evening snack, dinner
- Water target estimate and per-day tracking
- BMI and BMI-reference healthy-weight interval
- Role-based Spring Security

First-run admin:
admin@fittrack.local
ChangeAdmin123!

Change this password before any public/cloud deployment.

Nutrition:
V4 includes a small offline starter catalog for common foods. It is deliberately not presented as a comprehensive nutrition database. Production should connect to a vetted nutrition API/database and cache normalized serving data.

Estimates:
Distance, calorie burn, hydration and BMI outputs are estimates/screening information. Health Connect measured values should be preferred when available.

Upgrade:
For local development, Hibernate schema update can add columns. For production, use PostgreSQL + Flyway migrations.
