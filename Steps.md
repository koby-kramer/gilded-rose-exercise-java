# My thoughts and steps as I approach the problem.
## Initial Thoughts
My initial thoughts are that this is spahgetti code and easily doesn't follow SOLID priniciples. The criteria that the Item class cannot be touched is there, but that does not mean that the class cannot be extended following Open/Closed prinicple. We would also want to make the code more readable since readable code is much more important than run speed for smaller application (There is a limit on this idea, but regardless.) We would also want to shift the Items into a Hashmap to enhance the lookup speed, as well as redesign the update quality to call a method of the new class for each method. The question is do we use a custom class for each object or do we use an interface and extend that?

## Steps
1. Understand the business logic that we're trying to replicate.
2. Add more units test to ensure we don't break said business logic.
3. Extend the Item class to hold category for increased readability.
4. Refactor the Update Quantity to make more ledgeable and convert to Hashmap for easier lookups.
5. 