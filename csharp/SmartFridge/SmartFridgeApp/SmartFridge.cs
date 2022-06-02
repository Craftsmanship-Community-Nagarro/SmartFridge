using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmartFridgeApp
{
    public class SmartFridge
    {
        public DisplayData DisplayData()
        {
            return new DisplayData
            {
                ExpiredItems = new List<string>(),
                RemainingItems = new List<string>()
            };
        }
    }
}
