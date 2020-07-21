using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.UserServices.Models
{
    public partial class TParentInfo
    {
        public int Id { get; set; }
        public string ParentName { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string ChildrenNum { get; set; }
        public string SchoolName { get; set; }
    }
}
