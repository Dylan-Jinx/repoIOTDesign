using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class AccountDTO
    {
        public string Account { get; set; }
        public string Password { get; set; }
        public bool IsRememberMe { get; set; }
    }
}
