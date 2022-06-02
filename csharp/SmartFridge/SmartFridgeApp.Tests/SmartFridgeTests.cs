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
    }
}