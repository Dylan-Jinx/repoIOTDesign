using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.UserServices.Models
{
    public partial class TUserInfo
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string UserType { get; set; }
    }
}
