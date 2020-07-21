using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class DietaryNutritionContext : DbContext
    {
        public DietaryNutritionContext()
        {
        }

        public DietaryNutritionContext(DbContextOptions<DietaryNutritionContext> options)
            : base(options)
        {
        }

        public virtual DbSet<TCookBook> TCookBook { get; set; }
        public virtual DbSet<TFoodNutrition> TFoodNutrition { get; set; }
        public virtual DbSet<TNutrientInformation> TNutrientInformation { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseSqlServer("Data Source=123.56.152.95;Initial Catalog=DietaryNutrition;User ID=sa;Password=Jinx13850526746");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<TCookBook>(entity =>
            {
                entity.ToTable("T_CookBook");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TFoodNutrition>(entity =>
            {
                entity.ToTable("T_FoodNutrition");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TNutrientInformation>(entity =>
            {
                entity.ToTable("T_NutrientInformation");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Name).HasMaxLength(20);

                entity.Property(e => e.OtherName).HasMaxLength(20);

                entity.Property(e => e.Unit).HasMaxLength(20);
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
