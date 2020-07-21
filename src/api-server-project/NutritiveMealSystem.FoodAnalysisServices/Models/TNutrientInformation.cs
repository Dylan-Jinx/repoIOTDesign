using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TNutrientInformation
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string OtherName { get; set; }
        public string Unit { get; set; }
        public string Introduction { get; set; }
        public string DeSymptom { get; set; }
        public string MuchHarm { get; set; }
        public string Source { get; set; }
        public string FocusGroups { get; set; }
        public string HighContentOfSource { get; set; }
    }
}
