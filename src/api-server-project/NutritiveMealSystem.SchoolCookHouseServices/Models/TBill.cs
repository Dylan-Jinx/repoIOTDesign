using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.SchoolCookHouseServices.Models
{
    public partial class TBill
    {
        public int Id { get; set; }
        public double? Price { get; set; }
        public DateTime? BillDatetime { get; set; }
        public string Conductor { get; set; }
        public string Remark { get; set; }
    }
}
