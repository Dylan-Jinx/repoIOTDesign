using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace NutritiveMealSystem.SchoolCookHouseServices.Models
{
    public partial class SchoolCookHouseContext : DbContext
    {
        public SchoolCookHouseContext()
        {
        }

        public SchoolCookHouseContext(DbContextOptions<SchoolCookHouseContext> options)
            : base(options)
        {
        }

        public virtual DbSet<TBill> TBill { get; set; }
        public virtual DbSet<TCookHouseInfo> TCookHouseInfo { get; set; }
        public virtual DbSet<TStaff> TStaff { get; set; }
        public virtual DbSet<TStorage> TStorage { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseSqlServer("Data Source=123.56.152.95;Initial Catalog=SchoolCookHouse;User ID=sa;Password=Jinx13850526746");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<TBill>(entity =>
            {
                entity.ToTable("T_Bill");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.BillDatetime).HasColumnType("datetime");
            });

            modelBuilder.Entity<TCookHouseInfo>(entity =>
            {
                entity.ToTable("T_CookHouseInfo");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TStaff>(entity =>
            {
                entity.ToTable("T_Staff");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TStorage>(entity =>
            {
                entity.ToTable("T_Storage");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.StorageTime).HasColumnType("datetime");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
