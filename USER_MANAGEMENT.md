# User Management

This build adds:
- Registration
- Login/logout with Spring Security
- BCrypt password hashing
- Current-user name/avatar
- Editable profile and fitness goals
- Password change
- Per-user isolation for daily logs, meals, workouts, and water records

Default first-run demo:
Email: demo@fittrack.local
Password: ChangeMe123!

Change/remove this account before production.

Important: if you already ran the previous build against the same H2 database, delete the local `database` directory once before starting this rebuilt version because the schema changed to add user ownership. This resets old local data. For production/data preservation, use a formal Flyway migration instead.
