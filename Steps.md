# My thoughts and steps as I approach the problem.
## Initial Thoughts
My initial thoughts are that this is spahgetti code and easily doesn't follow SOLID priniciples. The criteria that the Item class cannot be touched is there, but that does not mean that the class cannot be extended following Open/Closed prinicple. We would also want to make the code more readable since readable code is much more important than run speed for smaller application (There is a limit on this idea, but regardless.) We would also want to shift the Items into a Hashmap to enhance the lookup speed, as well as redesign the update quality to call a method of the new class for each method. The question is do we use a custom class for each object or do we use an interface and extend that?

## Steps
1. Understand the business logic that we're trying to replicate.
2. Add more units test to ensure we don't break said business logic.
3. Extend the Item class to hold category for increased readability.
    - It seems that a category is the best way to handle this verses trying to implement a class for each item because they may or may not have special rules logic. Each of these special logics can be added to an extended but makes for much more code to manage.
4. Add addItem function to GildedRose. 
5. Convert Items to hashmap and put with addItems method. 
6. Refactor the Update Quantity to make more ledgeable.
7. add updateInventory method.
8. Update unit tests to call new methods.
9. Add unit test to test new features for Conjured items are working as intended.


### Notes on Logical Excenption:
There are a few logical exceptions that have arisen from this such as items having a sellIn greater than quality causing the item to be worthless prior to the sellIn date, AgedBrie having a sellIn less that 0 but does it increase in quality twice as fast, and ConjuredItems with sellIn less than 0 being degraded at four times (degrade twice as fast normally and then sellIn twice as fast).