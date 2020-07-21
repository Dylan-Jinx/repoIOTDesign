using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TTransportationEnvironmentInfo
    {
        public int Id { get; set; }
        public string Plate { get; set; }
        public string Driver { get; set; }
        public string Telephone { get; set; }
        public DateTime? DateTime { get; set; }
        public double? Temperature { get; set; }
        public double? Humidity { get; set; }
        public string ProductNumber { get; set; }
    }
}
