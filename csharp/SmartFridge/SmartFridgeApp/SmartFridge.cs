using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmartFridgeApp
{
    public class SmartFridge
    {
        public DateTime CurrentDate { get; set; }
        
        private List<Item> items = new List<Item>();

        public DisplayData DisplayData()
        {
            return new DisplayData
            {
                ExpiredItems = items.Where(item => item.Expiry < CurrentDate).Select(item => item.Name).ToList(),
                RemainingItems = items.Where(item => item.Expiry > CurrentDate).Select(item => item.Name).ToList()
            };
        }

        public void Add(Item item)
        {
            item.Added = CurrentDate;

            items.Add(item);
        }

        public void NextDay()
        {
            CurrentDate = CurrentDate.AddDays(1);
        }
    }
}
