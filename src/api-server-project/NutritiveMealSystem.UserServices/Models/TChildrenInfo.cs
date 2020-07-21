using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.UserServices.Models
{
    public partial class TChildrenInfo
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string StuNo { get; set; }
        public string Address { get; set; }
        public string ParentName { get; set; }
        public string SchoolName { get; set; }
    }
}
