using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace NutritiveMealSystem.UserServices.Models
{
    public partial class UserContext : DbContext
    {
        public UserContext()
        {
        }

        public UserContext(DbContextOptions<UserContext> options)
            : base(options)
        {
        }

        public virtual DbSet<TChildrenInfo> TChildrenInfo { get; set; }
        public virtual DbSet<TParentInfo> TParentInfo { get; set; }
        public virtual DbSet<TUserInfo> TUserInfo { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseSqlServer("Data Source=123.56.152.95;Initial Catalog=User;User ID=sa;Password=Jinx13850526746");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<TChildrenInfo>(entity =>
            {
                entity.ToTable("T_ChildrenInfo");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TParentInfo>(entity =>
            {
                entity.ToTable("T_ParentInfo");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            modelBuilder.Entity<TUserInfo>(entity =>
            {
                entity.ToTable("T_UserInfo");

                entity.Property(e => e.Id).HasColumnName("id");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
