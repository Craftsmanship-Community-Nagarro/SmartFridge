# SmartFridge

Smart Fridge Content

You have been hired as a developer for FridgeCraft, a fridge manufacturer who pride themselves on their craftsmanship of delivering a quality fridge. FridgeCraft have decided to adopt the trend of making a “smart” fridge, and it’s your job to build the software to integrate into the new test model.

The Research and Development team have given you the following requirements they want your program to have for the first iteration of the test model:
Track items placed into and out of the fridge
When an item is added, the fridge must scan the item and record:
- Item name
- Expiration date
- Timestamp when added

Every time the fridge is opened, the items already inside degrade their expiry by:
- 1 hour (unopened)
- 5 hours (opened)

Provide a formatted display to view the contents and their remaining expiry with the following order:
- Any items past their expiry must be displayed first with “EXPIRED: $item.name”
- The rest of the items are displayed by expiry with their name and the remaining days to expiry

An item is expired when the tracked expiry reaches midnight on the day after the expiration date.
Simulate days passed, so the functionality can be easily demonstrated

Design with TDD and with "Ping-Pong" pair programming(Driver and Navigator). Write a failing test for your partner and push your changes.  

https://katalyst.codurance.com/smart-fridge
