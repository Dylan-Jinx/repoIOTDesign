using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Linq.Expressions;
using NutritiveMealSystem.FoodAnalysisServices.Models;
using Microsoft.EntityFrameworkCore;
using NutritiveMealSystem.TraceabilityServices.Models;

namespace NutritiveMealSystem.FoodAnalysisServices
{
  public  class EFHelper<T> where T : class
    {
        private DietaryNutritionContext dbContent = new DietaryNutritionContext();
        /// <summary>
        /// 添加一条记录
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        public int Add(T t)
        {
            dbContent.Entry<T>(t).State= EntityState.Added;
            return dbContent.SaveChanges();
        }
        /// <summary>
        /// 删除一条记录
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        public int Delete(T t)
        {
            dbContent.Entry<T>(t).State = EntityState.Deleted;
            return dbContent.SaveChanges();
        }
        /// <summary>
        /// 修改一条记录
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        public int Update(T t)
        {
            dbContent.Entry<T>(t).State = EntityState.Modified;
            return dbContent.SaveChanges();
        }
        /// <summary>
        /// 条件查询
        /// </summary>
        /// <param name="where"></param>
        /// <returns></returns>
        public IQueryable<T> getList(Expression<Func<T,bool>> where)
        {
            return dbContent.Set<T>().Where(where);
        }
        /// <summary>
        /// 分页查询
        /// </summary>
        /// <typeparam name="Tkey"></typeparam>
        /// <param name="where">查询条件</param>
        /// <param name="orderBy">排序条件</param>
        /// <param name="pageSize">每一页多少条</param>
        /// <param name="pageIndex">显示第几页</param>
        /// <returns></returns>
        public IQueryable<T> getListByPage<Tkey>(Expression<Func<T,bool>>where,Expression<Func<T,Tkey>>orderBy,int pageSize,int pageIndex)
        {
            return dbContent.Set<T>().Where(where).OrderBy(orderBy).Skip((pageIndex - 1) * pageSize).Take(pageSize);
        }
    }
   
}
