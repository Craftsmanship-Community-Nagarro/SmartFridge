namespace SmartFridgeApp.Tests
{
    [TestClass]
    public class SmartFridgeTests
    {
        [TestMethod]
        public void EmptyFridge()
        {
            var smartFridge = new SmartFridge();
            var displayData = smartFridge.DisplayData();

            Assert.AreEqual(0, displayData.ExpiredItems.Count);
            Assert.AreEqual(0, displayData.RemainingItems.Count);
        }

        [TestMethod]
        public void FridgeShouldContainExpiredMilk()
        {
            var smartFridge = new SmartFridge
            {
                CurrentDate = new DateTime(2022, 8, 1)
            };

            smartFridge.Add(
                new Item
                {
                    Name = "Milk",
                    Expiry = new DateTime(2022,7, 15, 23, 59, 0)
                });


            var displayData = smartFridge.DisplayData();

            Assert.AreEqual(1, displayData.ExpiredItems.Count);
            Assert.AreEqual(0, displayData.RemainingItems.Count);
        }

    }
}