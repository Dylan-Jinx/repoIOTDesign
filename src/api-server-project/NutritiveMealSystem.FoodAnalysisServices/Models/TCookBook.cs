using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TCookBook
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Material { get; set; }
        public string Flavour { get; set; }
        public string Image { get; set; }
        public string NutritionalIngredient { get; set; }
    }
}
