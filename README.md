# springboot-security-sandbox

0. Initialize

- New sping boot project > choose web (web) and security (core)
- Run, go to localhost:8080. Login is user and credential is display on console output (for example cada4af1-9a3f-42df-b822-372c6b6835c7).
- When logged in you will see a Whitelabel Error Page.

1. Create a custom (hardcoded) user
- Open application.properties and add the folowing lines : 
security.user.name=jo
security.user.password=pass
- Restart and try new credential
