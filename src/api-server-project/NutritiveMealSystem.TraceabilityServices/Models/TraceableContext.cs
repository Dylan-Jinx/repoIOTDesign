using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TraceableContext : DbContext
    {
        public TraceableContext()
        {
        }

        public TraceableContext(DbContextOptions<TraceableContext> options)
            : base(options)
        {
        }

        public virtual DbSet<TPlantInfo> TPlantInfo { get; set; }
        public virtual DbSet<TProductNumInfo> TProductNumInfo { get; set; }
        public virtual DbSet<TProductionBaseInfo> TProductionBaseInfo { get; set; }
        public virtual DbSet<TProductionBaseStaff> TProductionBaseStaff { get; set; }
        public virtual DbSet<TTransportCompanyStaff> TTransportCompanyStaff { get; set; }
        public virtual DbSet<TTransportationCompanyInfo> TTransportationCompanyInfo { get; set; }
        public virtual DbSet<TTransportationEnvironmentInfo> TTransportationEnvironmentInfo { get; set; }
        public virtual DbSet<TWarehouseInfo> TWarehouseInfo { get; set; }
        public virtual DbSet<TWaterQualityInfo> TWaterQualityInfo { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseSqlServer("Data Source=123.56.152.95;Initial Catalog=Traceable;User ID=sa;Password=Jinx13850526746");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<TPlantInfo>(entity =>
            {
                entity.ToTable("T_PlantInfo");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.HarvestTime).HasColumnType("datetime");

                entity.Property(e => e.PlantTime).HasColumnType("datetime");
            });

            modelBuilder.Entity<TProductNumInfo>(entity =>
            {
                entity.ToTable("T_ProductNumInfo");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TProductionBaseInfo>(entity =>
            {
                entity.ToTable("T_ProductionBaseInfo");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TProductionBaseStaff>(entity =>
            {
                entity.ToTable("T_ProductionBaseStaff");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TTransportCompanyStaff>(entity =>
            {
                entity.ToTable("T_TransportCompanyStaff");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TTransportationCompanyInfo>(entity =>
            {
                entity.ToTable("T_TransportationCompanyInfo");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TTransportationEnvironmentInfo>(entity =>
            {
                entity.ToTable("T_TransportationEnvironmentInfo");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.DateTime).HasColumnType("datetime");
            });

            modelBuilder.Entity<TWarehouseInfo>(entity =>
            {
                entity.ToTable("T_WarehouseInfo");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TWaterQualityInfo>(entity =>
            {
                entity.ToTable("T_WaterQualityInfo");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.DateOfSampling).HasColumnType("datetime");

                entity.Property(e => e.Ph).HasColumnName("PH");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
