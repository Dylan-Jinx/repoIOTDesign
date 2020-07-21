using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.SchoolCookHouseServices.Models
{
    public partial class TStaff
    {
        public int Id { get; set; }
        public string StaffName { get; set; }
        public string Telephone { get; set; }
        public string Image { get; set; }
        public string Position { get; set; }
    }
}
