USE [master]
GO
/****** Object:  Database [DietaryNutrition]    Script Date: 2020/7/18 18:42:53 ******/
CREATE DATABASE [DietaryNutrition]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DietaryNutrition', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DietaryNutrition.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DietaryNutrition_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DietaryNutrition_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DietaryNutrition] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DietaryNutrition].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DietaryNutrition] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DietaryNutrition] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DietaryNutrition] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DietaryNutrition] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DietaryNutrition] SET ARITHABORT OFF 
GO
ALTER DATABASE [DietaryNutrition] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DietaryNutrition] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DietaryNutrition] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DietaryNutrition] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DietaryNutrition] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DietaryNutrition] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DietaryNutrition] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DietaryNutrition] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DietaryNutrition] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DietaryNutrition] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DietaryNutrition] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DietaryNutrition] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DietaryNutrition] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DietaryNutrition] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DietaryNutrition] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DietaryNutrition] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DietaryNutrition] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DietaryNutrition] SET RECOVERY FULL 
GO
ALTER DATABASE [DietaryNutrition] SET  MULTI_USER 
GO
ALTER DATABASE [DietaryNutrition] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DietaryNutrition] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DietaryNutrition] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DietaryNutrition] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DietaryNutrition] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DietaryNutrition', N'ON'
GO
ALTER DATABASE [DietaryNutrition] SET QUERY_STORE = OFF
GO
USE [DietaryNutrition]
GO
/****** Object:  Table [dbo].[T_CookBook]    Script Date: 2020/7/18 18:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_CookBook](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NULL,
	[Material] [nvarchar](max) NULL,
	[Flavour] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
	[NutritionalIngredient] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_CookBook] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_FoodNutrition]    Script Date: 2020/7/18 18:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_FoodNutrition](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[FoodName] [nvarchar](max) NULL,
	[NutritionalIngredient] [nvarchar](max) NULL,
	[Introduce] [nvarchar](max) NULL,
	[Images] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_FoodNutrition] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_NutrientInformation]    Script Date: 2020/7/18 18:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_NutrientInformation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](20) NULL,
	[OtherName] [nvarchar](20) NULL,
	[Unit] [nvarchar](20) NULL,
	[Introduction] [nvarchar](max) NULL,
	[DeSymptom] [nvarchar](max) NULL,
	[MuchHarm] [nvarchar](max) NULL,
	[Source] [nvarchar](max) NULL,
	[FocusGroups] [nvarchar](max) NULL,
	[HighContentOfSource] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_NutrientInformation] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[T_CookBook] ON 
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (1, N'鱼香肉丝', N'里脊、青笋、黑木耳、料酒、大蒜、生姜、大葱、豆瓣、淀粉、鸡蛋、花椒粒、干辣椒、水、', N'酱油，精盐，白糖，蚝油(可选)、生抽、胡椒粉', N'File/Uploads/鱼香肉丝.jpg', N'蛋白质20.3克，bai脂肪6.2克，碳水化合物1.5克，胆固醇81毫克，维生素A44微克，视黄醇44微克，硫胺素 0.54毫克，核黄素 0.1毫克，尼克酸5.3毫克，维生素E 0.34毫克，钙6毫克，磷189毫克，钾305毫克，钠57.5毫克，铁3毫克，锌2.99毫克，硒9.50微克')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (2, N'番茄炒蛋', N'鸡蛋 100克、番茄 200克', N'食盐 2克、白砂糖 2克', N'File/Uploads/番茄炒蛋.jpg', N'热量(大卡)80.53、碳水化合物(克)3.67、脂肪(克)5.43、蛋白质(克)4.79、纤维素(克)0.02 ')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (3, N'西红柿鸡蛋汤', N'鸡蛋 50.0g、番茄 50.0g、饮用水 200.0g、小葱 3.0g', N'食盐 2克、香油 2.0g', N'File/Uploads/西红柿鸡蛋汤.jpg', N'热量(大卡)32.22、碳水化合物(克)1.05、脂肪(克)2.13、蛋白质(克)2.34、纤维素(克)0.01 ')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (4, N'酸辣土豆丝', N'马铃薯 300克、青椒 15克、辣椒(红，小) 15克', N' 花椒 2克、辣椒(红，尖，干) 5克、大葱 5克、食盐 3克、味精 2克、香醋 5克、花生油 15克、香油 5克', N'File/Uploads/酸辣土豆丝.jpg', N'热量(大卡)121.50、 碳水化合物(克)14.43、脂肪(克)5.77、蛋白质(克)2.25、  纤维素(克)1.51')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (5, N'红烧肉', N'猪肉(肋条肉) 750克', N'酱油 30克、黄酒 30克、白砂糖 40克、大葱 10克、姜 10克', N'File/Uploads/红烧肉.jpg', N'热量(大卡)513.34、碳水化合物(克)5.13、 脂肪(克)50.88、蛋白质(克)8.30、纤维素(克)0.06')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (6, N'糖醋排骨', N'猪大排 5000克', N'食盐 70克、白砂糖 500克、味精 10克、辣椒粉 15克、醋 25克', N'File/Uploads/糖醋排骨.jpg', N'热量(大卡)271.62、碳水化合物(克)10.62、脂肪(克)18.18、蛋白质(克)16.40、纤维素(克)0.12')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (7, N'可乐鸡翅', N'鸡翅 500.0g、可乐型汽水 100.0g、姜 10.0g、大葱 10.0g、八角 5.0g', N'粟米油 10.0g酱油、10.0g、料酒 5.0g', N'File/Uploads/可乐鸡翅.jpg', N' 热量(大卡)173.08、 碳水化合物(克)6.22、 脂肪(克)10.67、 蛋白质(克)13.55、纤维素(克)0.40')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (8, N'回锅肉', N'猪肉(肋条肉) 400克、青蒜 100克大葱 10克、大蒜 10克', N'豆瓣酱 25克、甜面酱 10克、酱油 10克、料酒 5克、食盐 3克、味精 2克、豆油 20克、花生油 20克', N'File/Uploads/回锅肉.png', N' 热量(大卡)446.67、碳水化合物(克)2.97、脂肪(克)45.22、蛋白质(克)7.41、纤维素(克)0.40')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (9, N'水煮鱼', N'青鱼 150克、鸡蛋白（鸡蛋清） 20克、大葱 5克', N'花生油 5克、辣椒酱 20克、食盐 3克、姜汁 2克、味精 1克、玉米淀粉 2克', N'File/Uploads/水煮鱼.jpg', N'热量(大卡)121.70、碳水化合物(克)1.52、 脂肪(克)5.72、蛋白质(克)15.93、纤维素(克)0.28')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (10, N'韭菜炒鸡蛋', N'韭菜 200克、鸡蛋 200克', N'花生油 5克、食盐 2克', N'File/Uploads/韭菜炒鸡蛋.jpg', N'热量(大卡)94.09、碳水化合物(克)3.59、脂肪(克)5.75、蛋白质(克)7.71、纤维素(克)0.00')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (11, N'油焖大虾', N'对虾 500克、青蒜 5克、大葱 10克、姜 10克', N'料酒 15克、食盐 5克、味精 5克、白砂糖 20克、香油 30克、花生油 10克', N'File/Uploads/油焖大虾.jpg', N'热量(大卡)151.96、碳水化合物(克)6.11、脂肪(克)7.22、蛋白质(克)15.65、纤维素(克)0.09')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (12, N'南瓜粥', N'南瓜 250.0g、香大米 160.0g、糯米 60.0g、糙米 20.0g、玉米(黄，干) 20.0g、西麦即食燕麦片（旧包装） 20.0g、红枣 10.0g、 枸杞 10.0g、 饮用水 1500.0g', N'糖根据喜好放', N'File/Uploads/南瓜粥.jpg', N'热量(大卡)52.43、 碳水化合物(克)11.28、 脂肪(克)0.27、蛋白质(克)1.63、纤维素(克)0.47')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (13, N'拍黄瓜', N'黄瓜 150.0g', N'香油辣酱 3.0g、醋 10.0g、酱油 5.0g、食盐 1.0g、辣椒、5.0g', N'File/Uploads/拍黄瓜.jpg', N'热量(大卡)19.09、碳水化合物(克)3.34、脂肪(克)0.26、蛋白质(克)1.04、纤维素(克)0.56')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (14, N'紫菜汤', N'紫菜(干) 5.0g、虾皮 5.0g、饮用水 100.0g', N'胡椒粉 1.0g', N'File/Uploads/紫菜汤.jpg', N'热量(大卡)21.41、碳水化合物(克)1.80、脂肪(克)0.17、蛋白质(克)2.67、 纤维素(克)0.99')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (15, N'炸酱面', N'面条(干切面) 500.0g、猪肉(肥瘦) 300.0g、豆芽（绿豆芽） 50.0g、黄豆 15.0g、青豆（干） 15.0g、水萝卜 20.0g、大葱 5.0g、姜 5.0g、饮用水 1000.0g', N'黄酱 250.0g、味精 1.0g、花生油 15.0g', N'File/Uploads/炸酱面.jpg', N'热量(大卡)163.21、碳水化合物(克)21.28、脂肪(克)6.18、蛋白质(克)6.30、纤维素(克)0.67')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (16, N'牛肉面', N'酱牛肉 40.0g、面条（生） 120.0g、小白菜 80.0g、香菜 10.0g、平菇 20.0g、番茄 10.0g、饮用水 250.0g', N'食盐 2.0g、醋 4.0g、胡椒粉 3.0g、辣椒油 7.0g', N'File/Uploads/牛肉面.jpg', N' 热量(大卡)101.92、碳水化合物(克)15.80、脂肪(克)2.36、蛋白质(克)4.66、纤维素(克)0.37')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (17, N'红烧茄子', N'茄子(紫皮，长) 300克、辣椒(红，尖，干) 10克、大葱 5克、大蒜 10克、八角 2克', N'豌豆淀粉 10克、食盐 3克、酱油 20克、花生油 5克、豆瓣酱 10克', N'File/Uploads/红烧茄子.jpg', N'热量(大卡)60.85、碳水化合物(克)10.20、脂肪(克)1.96、蛋白质(克)2.04、纤维素(克)2.98')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (18, N'麻婆豆腐', N'豆腐 300克、猪肉(肥瘦) 50克、小葱 5克', N'五香豆豉 15克、料酒 5克、食盐 3克、味精 2克、豌豆淀粉 5克、花生油 12克、百里香 15克', N'File/Uploads/麻婆豆腐.jpg', N'热量(大卡)126.17、碳水化合物(克)5.37、脂肪(克)8.90、蛋白质(克)6.35、纤维素(克)0.53')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (19, N'宫保鸡丁', N'鸡胸脯肉 150克、花生米（油炸） 15克、黄瓜 130克、辣椒(红，尖，干) 10克、花椒 3克、大葱 10克、姜 5克、大蒜 5克', N'酱油 15克、白砂糖 5克、食盐 3克、料酒 15克、花生油 10克', N'File/Uploads/宫保鸡丁.jpg', N'热量(大卡)127.06、碳水化合物(克)7.37、脂肪(克)7.01、蛋白质(克)9.71、纤维素(克)2.31')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (20, N'红烧猪蹄', N'猪蹄 500克、大葱 10克、姜 5克、肉桂 2克', N'酱油 35克、料酒 6克、白砂糖 10克', N'File/Uploads/红烧猪蹄.jpg', N'热量(大卡)241.77、碳水化合物(克)2.64、脂肪(克)16.58、蛋白质(克)20.33、纤维素(克)0.20 ')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (21, N'农家小炒肉', N'青椒 205.0g、猪肉（瘦） 188.0g、姜 5.0g、洋葱 5.0g', N'味精 1.0g、湖盐 5.0g、料酒 5.0g、猪油(板油) 5.0g、醋 3.0g、生抽 10.0g', N'File/Uploads/农家小炒肉.jpg', N'热量(大卡)84.68、碳水化合物(克)3.55、脂肪(克)3.88、蛋白质(克)9.46、纤维素(克)0.04')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (22, N'红烧狮子头', N'猪肉(肥瘦) 500克、荸荠 200克、油菜 300克、姜 2克', N'胡椒粉 1克、食盐 2克、味精 5克、白砂糖 2克、酱油 10克、料酒 5克、花生油 75克', N'File/Uploads/红烧狮子头.jpg', N'热量(大卡)261.21、碳水化合物(克)5.18、脂肪(克)23.76、蛋白质(克)6.94、纤维素(克)0.51')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (23, N'炒青菜', N'上海青 250.0g、大蒜 5.0g', N'葵花籽油 10.0g、食盐 3.0g', N'File/Uploads/炒青菜.jpg', N'热量(大卡)52.72、碳水化合物(克)3.50、脂肪(克)3.92、蛋白质(克)1.67、纤维素(克)1.51')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (24, N'鸡蛋羹', N'鸡蛋 200克、饮用水 300克、小葱 10克', N'生抽 3克、香油 3克', N'File/Uploads/鸡蛋羹.jpg', N' 热量(大卡)61.67、碳水化合物(克)1.18、脂肪(克)4.00、蛋白质(克)5.21、纤维素(克)0.03')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (25, N'绿豆汤', N'饮用水 1000.0g、绿豆 100.0g', N'白砂糖 50.0g', N'File/Uploads/绿豆汤.jpg', N'热量(大卡)46.00、碳水化合物(克)9.73、脂肪(克)0.07、蛋白质(克)1.88、纤维素(克)0.56')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (26, N'烧茄子', N'茄子(紫皮，长) 500克、大葱 5克、姜 5克、大蒜 5克', N'酱油 25克、味精 5克、食盐 5克、豌豆淀粉 10克、花生油 30克', N'File/Uploads/烧茄子.jpg', N'热量(大卡)74.20、碳水化合物(克)7.05、脂肪(克)5.18、蛋白质(克)1.50、纤维素(克)1.67')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (27, N'绿豆粥', N'大米 25克、绿豆 25克、饮用水 1750克', N'糖根据喜好放', N'File/Uploads/绿豆粥.jpg', N'热量(大卡)48.29、碳水化合物(克)9.49、脂肪(克)0.11、蛋白质(克)2.07、纤维素(克)0.51')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (28, N'蛋炒饭', N'鸡蛋 60.0g、米饭 250.0g、食盐 3.0g、葱 10.0g', N'酱油 3.0g、油 10.0g', N'File/Uploads/蛋炒饭.jpg', N'热量(大卡)143.17、碳水化合物(克)20.47、脂肪(克)4.92、蛋白质(克)4.49、纤维素(克)0.25')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (29, N'清炒绿豆芽', N'豆芽（绿豆芽） 300克', N'菜籽油 10克、食盐 2克', N'File/Uploads/清炒绿豆芽.jpg', N'热量(大卡)44.20、碳水化合物(克)2.50、脂肪(克)3.30、蛋白质(克)1.63、纤维素(克)1.15')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (30, N'葱油饼', N'小麦粉(标准粉) 250.0g、饮用水 100.0g、小葱 50.0g', N'花生油 30.0g、食盐 10.0g', N'File/Uploads/葱油饼.jpg', N'热量(大卡)259.48、碳水化合物(克)42.38、脂肪(克)7.71、蛋白质(克)6.55、纤维素(克)1.35')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (31, N'清炒西葫芦', N'西葫芦 300.0g、饮用水 20.0g、大蒜 10.0g', N'豆油 10.0g、食盐 1.0g', N'File/Uploads/清炒西葫芦.jpg', N'热量(大卡)46.83、碳水化合物(克)4.15、脂肪(克)3.11、蛋白质(克)0.84、纤维素(克)0.56')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (32, N'西红柿鸡蛋面', N'鸡蛋 100.0g、饮用水 300.0g、番茄 200.0g、挂面 150.0g、小葱 10.0g', N'香油 5.0g、食盐 3.0g、鸡精 3.0g', N'File/Uploads/西红柿鸡蛋面.jpg', N'热量(大卡)98.18、碳水化合物(克)16.02、脂肪(克)2.03、蛋白质(克)4.24、纤维素(克)0.20')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (33, N'清爽西兰花', N'西兰花 200克、胡萝卜 100克', N'食盐 3克、胡椒粉 1克、鸡精 1克、香油 10克', N'File/Uploads/清爽西兰花.jpg', N'热量(大卡)63.29、碳水化合物(克)5.66、脂肪(克)3.63、蛋白质(克)2.99、纤维素(克)1.03')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (34, N'炒大白菜', N'大白菜 300.0g、辣椒(红，尖，干) 5.0g、大蒜 5.0g', N'食盐 3.0g、豆油 10.0g', N'File/Uploads/炒大白菜.jpg', N'热量(大卡)52.96、碳水化合物(克)4.40、脂肪(克)3.47、蛋白质(克)1.79、纤维素(克)1.50素(克)1.03')
GO
INSERT [dbo].[T_CookBook] ([id], [Name], [Material], [Flavour], [Image], [NutritionalIngredient]) VALUES (35, N'竹笋炒豆腐', N'豆腐两块，竹笋一两，香菇、油菜各少许', N'酱油、白糖、花椒水、葱末、料酒、味素、淀粉各少许', N'File/Uploads/竹笋炒豆腐.jpg', N'中医认为竹笋味甘、微寒，无毒。在药用上具有清热化痰、益气和胃、治消渴、利水道、利膈爽胃等功效。竹笋还具有低脂肪、低糖、多纤维的特点，食用竹笋不仅能促进肠道蠕动，帮助消化，去积食，防便秘，并有预防大肠癌的功效。')
GO
SET IDENTITY_INSERT [dbo].[T_CookBook] OFF
GO
SET IDENTITY_INSERT [dbo].[T_FoodNutrition] ON 
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (1, N'egg', N'

热量（大卡）144

胆固醇(毫克)585

维生素A(微克)234

钾(毫克)154

钠(毫克)131.5

磷(毫克)130

钙(毫克)56

硒(微克)14.34

蛋白质(克)13.3

镁(毫克)10

脂肪(克)8.8

碳水化合物(克)2.8

铁(毫克)2

维生素E(毫克)1.84

锌(毫克)1.1

维生素B2(毫克)0.27

烟酸(毫克)0.2

铜(毫克)0.15

维生素B1(毫克)0.11

锰(毫克)0.04', N'鸡蛋，又名鸡卵、鸡子，是母鸡所产的卵。其外有一层硬壳，内则有气室、卵白及卵黄部分。富含胆固醇，营养丰富。一个鸡蛋重约50克，含蛋白质7-8克，脂肪5-6克。鸡蛋蛋白质的氨基酸比例很适合人体生理需要、易为机体吸收，利用率高达98%以上，营养价值很高，是人类常食用的食物之一。含有很高的蛋白质。', N'File/Uploads/egg.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (2, N'meat', N'

热量（大卡）395

钾(毫克)162

磷(毫克)130

胆固醇(毫克)69

钠(毫克)57.5

脂肪(克)30.8

维生素A(微克)16

蛋白质(克)14.6

镁(毫克)12

钙(毫克)11

硒(微克)2.94

烟酸(毫克)2.8

铁(毫克)2.4

碳水化合物(克)1.1

维生素C(毫克)1
维生素E(毫克)0.95

锌(毫克)0.84

维生素B1(毫克)0.26

铜(毫克)0.13

维生素B2(毫克)0.11', N'猪肉，又名豚肉，是猪科动物家猪的肉。其性味甘咸平，含有丰富的蛋白质及脂肪、碳水化合物、钙、铁、磷等营养成分。猪肉是日常生活的主要副食品，具有补虚强身，滋阴润燥、丰肌泽肤的作用。凡病后体弱、产后血虚、面黄肌瘦者，皆可用之作营养滋补之品。', N'File/Uploads/meat.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (3, N'milk', N'热量（大卡）54

钾(毫克)109

钙(毫克)104

磷(毫克)73

钠(毫克)37.2

维生素A(微克)24

胆固醇(毫克)15

镁(毫克)11

碳水化合物(克)3.4

脂肪(克)3.2

蛋白质(克)3

硒(微克)1.94

维生素C(毫克)1

锌(毫克)0.42

铁(毫克)0.3维生素E(毫克)0.21

维生素B2(毫克)0.14

烟酸(毫克)0.1

锰(毫克)0.03

维生素B1(毫克)0.03

铜(毫克)0.02

', N'牛奶是最古老的天然饮料之一，被誉为白色血液。
牛奶中含有丰富的蛋白质、脂肪、维生素和矿物质等营养物质，乳蛋白中含有人体所必须的氨基酸；乳脂肪多为短链和中链脂肪酸，极易被人体吸收；钾、磷、钙等矿物质配比合理，易于人体吸收。', N'File/Uploads/milk.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (4, N'dragonfruit', N'

热量（大卡）51

叶酸(微克)28.1

碳水化合物(克)13.3

膳食纤维(克)2

蛋白质(克)1.1

脂肪(克)0.2

维生素B6(毫克)0.04
', N'火龙果（学名：Hylocereus undatus ''Foo-Lon''）是仙人掌科、量天尺属量天尺的栽培品种，攀援肉质灌木，具气根。分枝多数，延伸，叶片棱常翅状，边缘波状或圆齿状，深绿色至淡蓝绿色，骨质；花漏斗状，于夜间开放；鳞片卵状披针形至披针形，萼状花被片黄绿色，线形至线状披针形，瓣状花被片白色，长圆状倒披针形，花丝黄白色，花柱黄白色，浆果红色，长球形，果脐小，果肉白色、红色。种子倒卵形，黑色，种脐小。7-12月开花结果。
分布中美洲至南美洲北部，世界各地广泛栽培，藉气根攀援于树干、岩石或墙上，海拔3-300米。
该种分枝扦插容易成活，常作嫁接蟹爪属，仙人棒属和多种仙人球的砧木，花可作蔬菜，浆果可食，商品名“火龙果”。', N'File/Uploads/dragonfruit.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (5, N'banana', N'

热量（大卡）91

钾(毫克)256

胡萝卜素(微克)60

镁(毫克)43

磷(毫克)28

碳水化合物(克)22

维生素A(微克)10

维生素C(毫克)8

钙(毫克)7

碘(微克)2.5

蛋白质(克)1.4

膳食纤维(克)1.2

硒(微克)0.87

钠(毫克)0.8

烟酸(毫克)0.7
锰(毫克)0.65

铁(毫克)0.4

维生素E(毫克)0.24

脂肪(克)0.2

锌(毫克)0.18

铜(毫克)0.14

维生素B2(毫克)0.04

维生素B1(毫克)0.02', N'蕉（学名：Musa nana Lour.）芭蕉科芭蕉属植物，又指其果实，热带地区广泛种植。香蕉味香、富含营养，植株为大型草本，从根状茎发出，由叶鞘下部形成高3～6米（10～20尺）的假杆；叶长圆形至椭圆形，有的长达3～3.5米（10～11.5尺），宽65厘米（26寸），10～20枚簇生茎顶。穗状花序下垂，由假杆顶端抽出，花多数，淡黄色；果序弯垂，结果10～20串，约50～150个。植株结果后枯死，由根状茎长出的吸根继续繁殖，每一根株可活多年。原产亚洲东南部，台湾、海南、广东、广西等均有栽培。', N'File/Uploads/banana.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (6, N'apple', N'

热量（大卡）52

钾(毫克)119

胡萝卜素(微克)20

碳水化合物(克)13.5

磷(毫克)12

钙(毫克)4

镁(毫克)4

维生素C(毫克)4

维生素A(微克)3

维生素E(毫克)2.12

钠(毫克)1.6

膳食纤维(克)1.2

铁(毫克)0.6

烟酸(毫克)0.2

脂肪(克)0.2
蛋白质(克)0.2

锌(毫克)0.19

硒(微克)0.12

铜(毫克)0.06

维生素B1(毫克)0.06

锰(毫克)0.03

维生素B2(毫克)0.02

', N'
苹果是蔷薇科苹果亚科苹果属植物，其树为落叶乔木。苹果营养价值很高，富含矿物质和维生素，含钙量丰富，有助于代谢掉体内多余盐分，苹果酸可代谢热量，防止下半身肥胖。
苹果是一种低热量的食物，每100克产生大约60千卡左右的热量。苹果中营养成分可溶性大，容易被人体吸收，故有“活水”之称。它有利于溶解硫元素，使皮肤润滑柔嫩。
', N'File/Uploads/apple.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (7, N'pear', N'

热量（大卡）44

钾(毫克)92

胡萝卜素(微克)33

磷(毫克)14

碳水化合物(克)13.3

钙(毫克)9

镁(毫克)8

维生素C(毫克)6

维生素A(微克)6

膳食纤维(克)3.1

钠(毫克)2.1

维生素E(毫克)1.34

硒(微克)1.14

碘(微克)0.7

铜(毫克)0.62
铁(毫克)0.5

锌(毫克)0.46

蛋白质(克)0.4

烟酸(毫克)0.3

脂肪(克)0.2

锰(毫克)0.07

维生素B2(毫克)0.06

维生素B1(毫克)0.03', N'
梨，通常品种是一种落叶乔木或灌木，极少数品种为常绿，属于被子植物门双子叶植物纲蔷薇科苹果亚科。叶片多呈卵形，大小因品种不同而各异。花为白色，或略带黄色、粉红色，有五瓣。果实形状有圆形的，也有基部较细尾部较粗的，即俗称的“梨形”；不同品种的果皮颜色大相径庭，有黄色、绿色、黄中带绿、绿中带黄、黄褐色、绿褐色、红褐色、褐色，个别品种亦有紫红色；野生梨的果径较小，在1到4厘米之间，而人工培植的品种果径可达8厘米，长度可达18厘米。
梨的果实通常用来食用，不仅味美汁多，甜中带酸，而且营养丰富，含有多种维生素和纤维素，不同种类的梨味道和质感都完全不同。梨既可生食，也可蒸煮后食用。在医疗功效上，梨可以通便秘，利消化，对心血管也有好处。在民间，梨还有一种疗效，把梨去核，放入冰糖，蒸煮过后食用还可以止咳；除了作为水果食用以外，梨还可以作观赏之用。
', N'File/Uploads/pear.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (8, N'chicken', N'

热量（大卡）167

钾(毫克)340

胆固醇(毫克)187

磷(毫克)160

钠(毫克)72.4

维生素A(微克)42

蛋白质(克)18.5

钙(毫克)17

脂肪(克)9.6

镁(毫克)7

硒(微克)5.4

烟酸(毫克)5

维生素C(毫克)3

碳水化合物(克)1.4

锌(毫克)1.29
铁(毫克)0.9

维生素E(毫克)0.2

铜(毫克)0.08

维生素B2(毫克)0.08

维生素B1(毫克)0.07', N'鸡肉（chicken），指鸡身上的肉，鸡的肉质细嫩，滋味鲜美，适合多种烹调方法，并富有营养，有滋补养身的作用。鸡肉不但适于热炒、炖汤，而且是比较适合冷食凉拌的肉类。', N'File/Uploads/chicken.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (9, N'corn', N'

热量（大卡）196

钾(毫克)238

磷(毫克)117

维生素A(微克)63

镁(毫克)32

碳水化合物(克)22.8

维生素C(毫克)16

蛋白质(克)4

膳食纤维(克)2.9

烟酸(毫克)1.8

硒(微克)1.63

脂肪(克)1.2

钠(毫克)1.1

铁(毫克)1.1

钙(毫克)1
锌(毫克)0.9

维生素E(毫克)0.46

胡萝卜素(微克)0.34

维生素B1(毫克)0.16

维生素B2(毫克)0.11

铜(毫克)0.09

', N'玉米（Zea mays L.）是禾本科的一年生草本植物。又名苞谷、苞米棒子、玉蜀黍、珍珠米等。原产于中美洲和南美洲，它是世界重要的粮食作物，广泛分布于美国、中国、巴西和其他国家。玉米与传统的水稻、小麦等粮食作物相比，玉米具有很强的耐旱性、耐寒性、耐贫瘠性以及极好的环境适应性。玉米的营养价值较高，是优良的粮食作物。作为中国的高产粮食作物，玉米是畜牧业、养殖业、水产养殖业等的重要饲料来源，也是食品、医疗卫生、轻工业、化工业等的不可或缺的原料之一。由于玉米资源极为丰富、廉价且易于获得，它们还具有许多生物活性，如抗氧化、抗肿瘤、降血糖、提高免疫力和抑菌杀菌等，其具有广阔的开发及应用前景。', N'File/Uploads/corn.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (10, N'pineapple', N'热量(千卡)41硫胺素(毫克)0.04钙(毫克)12蛋白质(克)0.5核黄素(毫克)0.02镁(毫克)8脂肪(克)0.1烟酸(毫克)0.2铁(毫克)0.6碳水化合物(克)9.5维生素C(毫克)18锰(毫克)1.04膳食纤维(克)1.3维生素E(毫克)0锌(毫克)0.14维生素A(微克)3胆固醇(毫克)0铜(毫克)0.07胡罗卜素(微克)0.2钾(毫克)113磷(毫克)9视黄醇当量(微克)88.4钠(毫克)0.8硒(微克)0.24', N'菠萝（学名：Ananas comosus），是热带水果之一。福建和台湾地区称之为旺梨或者旺来（ông-lâi），新马一带称为黄梨，大陆及香港称作菠萝。有70多个品种，岭南四大名果之一。菠萝原产于南美洲巴西、巴拉圭的亚马逊河流域一带，16世纪从巴西传入中国。 已经流传到整个热带地区。其可食部分主要由肉质增大之花序轴、螺旋状排列于外周的花组成，花通常不结实，宿存的花被裂片围成一空腔，腔内藏有萎缩的雄蕊和花柱。叶的纤维甚坚韧，可供织物、制绳、结网和造纸。凤梨与菠萝在生物学上是同一种水果。市场上，凤梨与菠萝为不同品种水果：菠萝削皮后有“内刺”需要剔除；而凤梨削掉外皮后没有“内刺”，不需要刀划出一道道沟。', N'File/Uploads/pineapple.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (11, N'beef', N'热量	288	大卡 碳水化合物	0	克 脂肪	19.54	克 蛋白质	26.33	克 纤维素	0	克 钠	384	毫克 钾	315	毫克', N'牛肉，指从牛身上获得的肉，为常见的肉品之一，来源可以是奶牛、公牛、小母牛，牛的肌肉部分可以切成牛排、牛肉块或牛仔骨，也可以与其他的肉混合做成香肠或血肠，其他部位可食用的还有牛尾、牛肝、牛舌、牛百叶、牛胰腺、牛胸腺、牛心、牛脑、牛肾、牛鞭，牛肠也可以吃，不过常用来做香肠衣，牛骨可用做饲料', N'File/Uploads/beef.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (12, N'pumpkin', N'热量(千卡) 22 硫胺素(毫克) 0.03 钙(毫克) 16 蛋白质(克) 0.7 核黄素(毫克) 0.04 镁(毫克) 8 脂肪(克) 0.1 烟酸(毫克) 0.4 铁(毫克) 0.4 碳水化合物(克) 4.5 维生素C(毫克) 8 锰(毫克) 0.08 膳食纤维(克) 0.8 维生素E(毫克) 0.36 锌(毫克) 0.14 维生素A(微克) 148 胆固醇(毫克) 0 铜(毫克) 0.03 胡罗卜素(微克) 0.4 钾(毫克) 145 磷(毫克) 24 视黄醇当量(微克) 93.5 钠(毫克) 0.8 硒(微克) 0.46', N'南瓜（学名：Cucurbita moschata (Duch. ex Lam.) Duch. ex Poiret）葫芦科南瓜属的一个种，一年生蔓生草本植物，茎常节部生根，叶柄粗壮，叶片宽卵形或卵圆形，质稍柔软，叶脉隆起，卷须稍粗壮，雌雄同株，果梗粗壮，有棱和槽，因品种而异，外面常有数条纵沟或无，种子多数，长卵形或长圆形。 原产墨西哥到中美洲一带，世界各地普遍栽培。明代传入中国，现南北各地广泛种植。 南瓜的果实作肴馔，亦可代粮食。全株各部又供药用，种子含南瓜子氨基酸，有清热除湿、驱虫的功效，对血吸虫有控制和杀灭的作用，藤有清热的作用，瓜蒂有安胎的功效，根治牙痛。', N'File/Uploads/pumpkin.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (13, N'watermelon', N'热量(千卡) 25 硫胺素(毫克) 0.02 钙(毫克) 8 蛋白质(克) 0.6 核黄素(毫克) 0.03 镁(毫克) 8 脂肪(克) 0.1 烟酸(毫克) 0.2 铁(毫克) 0.3 碳水化合物(克) 5.5 维生素C(毫克) 6 锰(毫克) 0.05 膳食纤维(克) 0.3 维生素E(毫克) 0.1 锌(毫克) 0.1 维生素A(微克) 75 胆固醇(毫克) 0 铜(毫克) 0.05 胡罗卜素(微克) 0.2 钾(毫克) 87 磷(毫克) 9 视黄醇当量(微克) 93.3 钠(毫克) 3.2 硒(微克) 0.17', N'西瓜（学名：Citrullus lanatus (Thunb.) Matsum. et Nakai）一年生蔓生藤本；茎、枝粗壮，具明显的棱。卷须较粗壮，具短柔毛，叶柄粗，密被柔毛；叶片纸质，轮廓三角状卵形，带白绿色，两面具短硬毛，叶片基部心形。雌雄同株。雌、雄花均单生于叶腋。雄花花梗长3-4厘米，密被黄褐色长柔毛；花萼筒宽钟形；花冠淡黄色；雄蕊近离生，花丝短，药室折曲。雌花：花萼和花冠与雄花同；子房卵形，柱头肾形。果实大型，近于球形或椭圆形，肉质，多汁，果皮光滑，色泽及纹饰各式。种子多数，卵形，黑色、红色，两面平滑，基部钝圆，通常边缘稍拱起，花果期夏季。 中国各地栽培，品种甚多，外果皮、果肉及种子形式多样，以新疆、甘肃兰州、山东德州、江苏东台等地最为有名。其原种可能来自非洲，广泛栽培于世界热带到温带，后传入中国。 西瓜为夏季之水果，果肉味甜，能降温去暑；种子含油，可作消遣食品；果皮药用，有清热、利尿、降血压之效。', N'File/Uploads/watermelon.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (14, N'wheat', N'热量(千卡) 317 硫胺素(毫克) 0.4 钙(毫克) 34 蛋白质(克) 11.9 核黄素(毫克) 0.1 镁(毫克) 4 脂肪(克) 1.3 烟酸(毫克) 4 铁(毫克) 5.1 碳水化合物(克) 64.4 维生素C(毫克) 0 锰(毫克) 3.1 膳食纤维(克) 10.8 维生素E(毫克) 1.82 锌(毫克) 2.33 维生素A(微克) 0 胆固醇(毫克) 0 铜(毫克) 0.43 胡罗卜素(微克) 1.6 钾(毫克) 289 磷(毫克) 325 视黄醇当量(微克) 10 钠(毫克) 6.8 硒(微克) 4.05', N' 小麦是小麦属植物的统称，代表种为普通小麦（学名：Triticum aestivum L.）是禾本科植物，是一种在世界各地广泛种植的谷类作物，小麦的颖果是人类的主食之一，磨成面粉后可制作面包、馒头、饼干、面条等食物，发酵后可制成啤酒、酒精、白酒（如伏特加），或生物质燃料。 小麦是三大谷物之一，几乎全作食用，仅约有六分之一作为饲料使用。两河流域是世界上最早栽培小麦的地区，中国是世界较早种植小麦的国家之一。', N'File/Uploads/wheat.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (15, N'eggplant', N'热量(千卡) 19 硫胺素(毫克) 0.03 钙(毫克) 55 蛋白质(克) 1 核黄素(毫克) 0.03 镁(毫克) 15 脂肪(克) 0.1 烟酸(毫克) 0.6 铁(毫克) 0.4 碳水化合物(克) 3.5 维生素C(毫克) 7 锰(毫克) 0.14 膳食纤维(克) 1.9 维生素E(毫克) 0.2 锌(毫克) 0.16 维生素A(微克) 30 胆固醇(毫克) 0 铜(毫克) 0.07 胡罗卜素(微克) 0.4 钾(毫克) 136 磷(毫克) 28 视黄醇当量(微克) 93.1 钠(毫克) 6.4 硒(微克) 0.57', N'茄（学名：Solanum melongena L.）茄科，茄属植物。茄直立分枝草本至亚灌木，高可达1米，小枝，叶柄及花梗均被6-8-（10）分枝，平贴或具短柄的星状绒毛，小枝多为紫色（野生的往往有皮刺），渐老则毛被逐渐脱落。叶大，卵形至长圆状卵形，叶柄长约2-4.5厘米（野生的具皮刺）。能孕花单生，花柄长约1-1.8厘米，毛被较密。果的形状大小变异极大。果的形状有长或圆，颜色有白、红、紫等。 果可供蔬食。根、茎、叶入药，为收敛剂，有利尿之效，叶也可以作麻醉剂。种子为消肿药，也用为刺激剂，但容易引起胃弱及便秘，果生食可解食菌中毒。 原产亚洲热带，中国各省均有栽培。', N'File/Uploads/eggplant.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (16, N'tomato', N'热量(千卡) 19 硫胺素(毫克) 0.03 钙(毫克) 10 蛋白质(克) 0.9 核黄素(毫克) 0.03 镁(毫克) 9 脂肪(克) 0.2 烟酸(毫克) 0.6 铁(毫克) 0.4 碳水化合物(克) 3.5 维生素C(毫克) 19 锰(毫克) 0.08 膳食纤维(克) 0.5 维生素E(毫克) 0.57 锌(毫克) 0.13 维生素A(微克) 92 胆固醇(毫克) 0 铜(毫克) 0.06 胡罗卜素(微克) 0.5 钾(毫克) 163 磷(毫克) 23 视黄醇当量(微克) 94.4 钠(毫克) 5 硒(微克) 0.15', N'番茄（学名：Solanum lycopersicum），即西红柿，是管状花目、茄科、番茄属的一种一年生或多年生草本植物，体高0.6～2米，全体生粘质腺毛，有强烈气味，茎易倒伏，叶羽状复叶或羽状深裂，花序总梗长2～5厘米，常3～7朵花，花萼辐状，花冠辐状，浆果扁球状或近球状，肉质而多汁液，种子黄色，花果期夏秋季。 番茄原产南美洲，中国南北方广泛栽培。番茄的果实营养丰富，具特殊风味。可以生食、煮食、加工番茄酱、汁或整果罐藏。', N'File/Uploads/tomato.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (17, N'Onions', N'热量(千卡) 330 硫胺素(毫克) 0.16 钙(毫克) 186 蛋白质(克) 5.5 核黄素(毫克) 0.16 镁(毫克) 49 脂肪(克) 0.4 烟酸(毫克) 1 铁(毫克) 0.9 碳水化合物(克) 76.2 维生素C(毫克) 22 锰(毫克) 0.62 膳食纤维(克) 5.7 维生素E(毫克) 0 锌(毫克) 1.02 维生素A(微克) 5 胆固醇(毫克) 0 铜(毫克) 0.45 胡罗卜素(微克) 3.1 钾(毫克) 740 磷(毫克) 78 视黄醇当量(微克) 9.1 钠(毫克) 31.7 硒(微克) 3.91', N'洋葱（学名：Allium cepa L.）是百合科、葱属多年生草本植物。鳞茎粗大，近球状；纸质至薄革质，内皮肥厚，肉质，叶片圆筒状，中空，中部以下最粗，向上渐狭，比花葶短，花葶粗壮，高可达1米，伞形花序球状，具多而密集的花；花粉白色；花被片具绿色中脉，矩圆状卵形，花丝等长，子房近球状，腹缝线基部具有帘的凹陷蜜穴；5～7月开花结果。 原产亚洲西部，中国内外均广泛栽培。是中国主栽蔬菜之一。中国的洋葱产地主要有福建、山东、甘肃、内蒙古、新疆等地。 洋葱含有前列腺素A，能降低外周血管阻力，降低血黏度，可用于降低血压、提神醒脑、缓解压力、预防感冒。此外，洋葱还能清除体内氧自由基，增强新陈代谢能力，抗衰老，预防骨质疏松，是适合中老年人的保健食物。', N'File/Uploads/Onions.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (18, N'parsley', N'热量(千卡) 293 硫胺素(毫克) 0.17 钙(毫克) 1723 蛋白质(克) 7.4 核黄素(毫克) 0.28 镁(毫克) 269 脂肪(克) 1.3 烟酸(毫克) 6 铁(毫克) 22.3 碳水化合物(克) 63 维生素C(毫克) 75 锰(毫克) 2.46 膳食纤维(克) 8.2 维生素E(毫克) 22.15 锌(毫克) 1.71 维生素A(微克) 472 胆固醇(毫克) 0 铜(毫克) 1.65 胡罗卜素(微克) 10.8 钾(毫克) 1031 磷(毫克) 151 视黄醇当量(微克) 9.3 钠(毫克) 1217.5 硒(微克) 14.15', N' 芫荽，别名胡荽、香菜、香荽。为双子叶植物纲、伞形目、伞形科、芫荽属的一个植物种，一、二年生草本植物，是人们熟悉的提味蔬菜，状似芹，叶小且嫩，茎纤细，味郁香，是汤、饮中的佐料，多用于做凉拌菜佐料，或烫料、面类菜中提味用。 药用价值：起表出体外又可开胃消郁还可止痛解毒，《本草纲目》称“芫荽性味辛温香窜，内通心脾，外达四肢”。 原产地为地中海沿岸及中亚地区，现大部地区都有种植。', N'File/Uploads/parsley.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (19, N'Chinese cabbage', N'热量(千卡) 17 硫胺素(毫克) 0.04 钙(毫克) 50 蛋白质(克) 1.5 核黄素(毫克) 0.05 镁(毫克) 11 脂肪(克) 0.1 烟酸(毫克) 0.6 铁(毫克) 0.7 碳水化合物(克) 2.4 维生素C(毫克) 31 锰(毫克) 0.15 膳食纤维(克) 0.8 维生素E(毫克) 0.76 锌(毫克) 0.38 维生素A(微克) 20 胆固醇(毫克) 0 铜(毫克) 0.05 胡罗卜素(微克) 0.6 钾(毫克) 0 磷(毫克) 31 视黄醇当量(微克) 94.6 钠(毫克) 57.5 硒(微克) 0.49', N' 白菜是我国原产蔬菜，有悠久的栽培历史。据考证，在我国新石器时期的西安半坡原始村落遗址发现的白菜籽距今约有6000年-7000年。明代李时珍引陆佃《埤雅》说：“菘，凌冬晚凋，四时常见，有松之操，故曰菘，今俗谓之白菜。” [1]  白菜19世纪传入日本、欧美各国。如今的白菜种类很多，北方的白菜有山东胶州大白菜、北京青白、东北大矮白菜、山西阳城的大毛边等。南方的白菜是由北方引进的，其品种有乌金白、蚕白菜、鸡冠白、雪里青等，都是优良品种。 [1]  白菜为东北及华北冬、春季主要蔬菜。菜叶可供炒食、生食、盐腌、酱渍，外层脱落的菜叶尚可作饲料。', N'File/Uploads/Chinese cabbage.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (20, N'potatoes', N'热量(千卡) 76 硫胺素(毫克) 0.08 钙(毫克) 8 蛋白质(克) 2 核黄素(毫克) 0.04 镁(毫克) 23 脂肪(克) 0.2 烟酸(毫克) 1.1 铁(毫克) 0.8 碳水化合物(克) 16.5 维生素C(毫克) 27 锰(毫克) 0.14 膳食纤维(克) 0.7 维生素E(毫克) 0.34 锌(毫克) 0.37 维生素A(微克) 5 胆固醇(毫克) 0 铜(毫克) 0.12 胡罗卜素(微克) 0.8 钾(毫克) 342 磷(毫克) 40 视黄醇当量(微克) 79.8 钠(毫克) 2.7 硒(微克) 0.78', N'马铃薯（学名：Solanum tuberosum L.），属茄科，一年生草本植物，块茎可供食用，是全球第四大重要的粮食作物，仅次于小麦、稻谷和玉米。马铃薯又名山药蛋、洋芋、洋山芋、洋芋头、香山芋、洋番芋、山洋芋、阳芋、地蛋、土豆等。马铃薯在不同国度，名称称谓也不一样，如美国称爱尔兰豆薯、俄罗斯称荷兰薯、法国称地苹果、德国称地梨、意大利称地豆、秘鲁称巴巴等。与小麦、稻谷、玉米、高粱并称为世界五大作物。马铃薯块茎含有大量的淀粉，能为人体提供丰富的热量，且富含蛋白质、氨基酸及多种维生素、矿物质，尤其是其维生素含量是所有粮食作物中最全的，在欧美国家特别是北美，马铃薯早就成为第二主食。马铃薯原产于南美洲安第斯山区，人工栽培历史最早可追溯到大约公元前8000年到5000年的秘鲁南部地区。马铃薯主要生产国有中国、俄罗斯、印度、乌克兰、美国等。中国是世界马铃薯总产最多的国家。', N'File/Uploads/potatoes.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (21, N'ginger', N'热量(千卡) 41 硫胺素(毫克) 0.02 钙(毫克) 27 蛋白质(克) 1.3 核黄素(毫克) 0.03 镁(毫克) 44 脂肪(克) 0.6 烟酸(毫克) 0.8 铁(毫克) 1.4 碳水化合物(克) 7.6 维生素C(毫克) 4 锰(毫克) 3.2 膳食纤维(克) 2.7 维生素E(毫克) 0 锌(毫克) 0.34 维生素A(微克) 28 胆固醇(毫克) 0 铜(毫克) 0.14 胡罗卜素(微克) 0.8 钾(毫克) 295 磷(毫克) 25 视黄醇当量(微克) 87 钠(毫克) 14.9 硒(微克) 0.56', N'姜（学名：Zingiber officinale Rosc.），姜科姜属多年生草本植物。开有黄绿色花并有刺激性香味的根茎。株高0.5-1米；根茎肥厚，多分枝，有芳香及辛辣味。叶片披针形或线状披针形，无毛，无柄；叶舌膜质。总花梗长达25厘米；穗状花序球果状；苞片卵形，淡绿色或边缘淡黄色，顶端有小尖头。花萼管长约1厘米；花冠黄绿色，裂片披针形；唇瓣中央裂片长圆状倒卵形。 在中国中部、东南部至西南部，咸丰活龙来凤、通山、阳新、鄂城、咸宁、大冶各省区广为栽培。亚洲热带地区亦常见栽培。 根茎供药用，鲜品或干品可作烹调配料或制成酱菜、糖姜。茎、叶、根茎均可提取芳香油，用于食品、饮料及化妆品香料中。', N'File/Uploads/ginger.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (22, N'Soy Sauce ', N'热量(千卡) 63 硫胺素(毫克) 0.05 钙(毫克) 66 蛋白质(克) 5.6 核黄素(毫克) 0.13 镁(毫克) 156 脂肪(克) 0.1 烟酸(毫克) 1.7 铁(毫克) 8.6 碳水化合物(克) 9.9 维生素C(毫克) 0 锰(毫克) 1.11 膳食纤维(克) 0.2 维生素E(毫克) 0 锌(毫克) 1.17 维生素A(微克) 0 胆固醇(毫克) 0 铜(毫克) 0.06 胡罗卜素(微克) 16.9 钾(毫克) 337 磷(毫克) 204 视黄醇当量(微克) 67.3 钠(毫克) 5757 硒(微克) 1.39', N'酱油是中国传统的调味品，用大豆或脱脂大豆或黑豆、小麦或麸皮，加入水、食盐酿造而成的液体调味品，色泽呈红褐色，有独特酱香，滋味鲜美，有助于促进食欲。 酱油是由酱演变而来，早在三千多年前，中国周朝就有制做酱的记载了，而中国古代劳动人民发明酱油之酿造纯粹是偶然地发现，中国古代皇帝御用的调味品，最早的酱油是由鲜肉腌制而成，与现今的鱼露制造过程相近，因为风味绝佳渐渐流传到民间，后来发现大豆制成风味相似且便宜，才广为流传食用，而早期随着佛教僧侣之传播，遍及世界各地，如日本、韩国、东南亚一带，中国酱油之制造，早期是一种家事艺术与秘密，其酿造多由某个师傅把持，其技术往往是由子孙代代相传或由一派的师傅传授下去，形成某一方式之酿造法。', N'File/Uploads/Soy Sauce .jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (23, N'vinegar ', N'热量(千卡) 31 硫胺素(毫克) 0.03 钙(毫克) 17 蛋白质(克) 2.1 核黄素(毫克) 0.05 镁(毫克) 13 脂肪(克) 0.3 烟酸(毫克) 1.4 铁(毫克) 6 碳水化合物(克) 4.9 维生素C(毫克) 0 锰(毫克) 2.97 膳食纤维(克) 0 维生素E(毫克) 0 锌(毫克) 1.25 维生素A(微克) 0 胆固醇(毫克) 0 铜(毫克) 0.04 胡罗卜素(微克) 2.1 钾(毫克) 351 磷(毫克) 96 视黄醇当量(微克) 90.6 钠(毫克) 262.1 硒(微克) 2.43', N'醋（Vinegar [1]  ）是中国各大菜系中传统的调味品 [2]  。据现有文字记载，中国古代劳动人民以酒作为发酵剂来发酵酿制食醋，东方醋起源于中国，据有文献记载的酿醋历史至少也在三千年以上。“醋”中国古称“酢”、“醯”、“苦酒”等。“酉”是“酒”字最早的甲骨文。同时把“醋”称之为“苦酒”，也同样说明“醋”是起源于“酒”的。 中国著名的醋有“神秘湘西”原香醋、镇江香醋、山西老陈醋、保宁醋、天津独流老醋、福建永春老醋、广灵登场堡醋、岐山醋、河南老鳖一特醋及红曲米醋。经常喝醋能够起到消除疲劳等作用，醋还可以缓解感冒引起的并发症的作用。', N'File/Uploads/vinegar .jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (24, N'Instant Noodles ', N'热量(千卡) 472 硫胺素(毫克) 0.12 钙(毫克) 25 蛋白质(克) 9.5 核黄素(毫克) 0.06 镁(毫克) 38 脂肪(克) 21.1 烟酸(毫克) 0.9 铁(毫克) 4.1 碳水化合物(克) 60.9 维生素C(毫克) 0 锰(毫克) 0.79 膳食纤维(克) 0.7 维生素E(毫克) 2.28 锌(毫克) 1.06 维生素A(微克) 0 胆固醇(毫克) 0 铜(毫克) 0.29 胡罗卜素(微克) 4.2 钾(毫克) 134 磷(毫克) 80 视黄醇当量(微克) 3.6 钠(毫克) 1144 硒(微克) 10.49', N' 方便面，又称快餐面、泡面、杯面、快熟面、速食面、即食面，南方一般称为碗面，香港则称之为公仔面。是一种可在短时间之内用热水泡熟食用的面制食品。广义上是指一种可在短时间之内用热水泡熟食用的面制食品，有相关的菜肴如归泡面、泡面沙拉等；狭义的方便面上通常指由面饼、调料包及油包组成的销售成品，市面上以袋装和杯或碗装居多。安藤百福在1958年发明了方便面，随着生活节奏加快及旅行需要，方便面成为现代生活不可或缺的简易食品之一。 方便面是通过对切丝出来的面条进行蒸煮、油炸，让面条形状固定（一般为方形或圆形），食用前以开水冲泡，溶解调味料，并将面条加热冲泡开，在短时间（一般在3分钟内）内便可食用的即食方便食品。 如今市场上各种品牌的方便面充斥着各大商场的货架，从大型零售超市到街头的小门头商铺都能够看到它的身影。', N'File/Uploads/Instant Noodles .jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (25, N'oatmeal ', N'热量(千卡) 351 硫胺素(毫克) 0.2 钙(毫克) 8 蛋白质(克) 12.4 核黄素(毫克) 0.06 镁(毫克) 108 脂肪(克) 7.4 烟酸(毫克) 4.5 铁(毫克) 4.2 碳水化合物(克) 58.7 维生素C(毫克) 0 锰(毫克) 3.06 膳食纤维(克) 8.6 维生素E(毫克) 1.45 锌(毫克) 2.15 维生素A(微克) 0 胆固醇(毫克) 0 铜(毫克) 0.44 胡罗卜素(微克) 1.6 钾(毫克) 306 磷(毫克) 339 视黄醇当量(微克) 11.3 钠(毫克) 20.9 硒(微克) 6.13', N'麦片(oatmeal)：是一种以小麦为原料加工而成的食品。是用普通的麦子和一些东西加工而成的。它曾经是第一种被工业化生产的早餐谷物食品。麦片的“片”字是指，它是一种来自被煮过，辗碎，和加以烘干的谷物，通常被放在牛奶和果汁里，或做成麦片粥加以食用。 麦片还分为普通麦片和燕麦片，燕麦片是由燕麦做成的，由于麦片食品的制作过程简单，而且省时，有的种类的麦片，只要经过水泡，就可以食用，所以受到了很多人的欢迎。', N'File/Uploads/oatmeal .jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (26, N'soya bean', N'热量(千卡) 359 硫胺素(毫克) 0.41 钙(毫克) 191 蛋白质(克) 35 核黄素(毫克) 0.2 镁(毫克) 199 脂肪(克) 16 烟酸(毫克) 2.1 铁(毫克) 8.2 碳水化合物(克) 18.7 维生素C(毫克) 0 锰(毫克) 2.26 膳食纤维(克) 15.5 维生素E(毫克) 18.9 锌(毫克) 3.34 维生素A(微克) 37 胆固醇(毫克) 0 铜(毫克) 1.35 胡罗卜素(微克) 4.6 钾(毫克) 1503 磷(毫克) 465 视黄醇当量(微克) 10.2 钠(毫克) 2.2 硒(微克) 6.16', N'大豆（学名：Glycine max (Linn.) Merr.）通称黄豆。为双子叶植物纲、豆科、大豆属的一年生草本，高30-90厘米。茎粗壮，直立，密被褐色长硬毛。叶通常具3小叶；托叶具脉纹，被黄色柔毛；叶柄长2-20厘米；小叶宽卵形，纸质；总状花序短的少花，长的多花；总花梗通常有5-8朵无柄、紧挤的花；苞片披针形，被糙伏毛；小苞片披针形，被伏贴的刚毛；花萼披针形，花紫色、淡紫色或白色，基部具瓣柄，翼瓣蓖状。荚果肥大，稍弯，下垂，黄绿色，密被褐黄色长毛；种子2-5颗，椭圆形、近球形，种皮光滑，有淡绿、黄、褐和黑色等多样。花期6-7月，果期7-9月。 原产中国，中国各地均有栽培，亦广泛栽培于世界各地。大豆是中国重要粮食作物之一，已有五千年栽培历史，古称菽，中国东北为主产区，是一种其种子含有丰富植物蛋白质的作物。大豆最常用来做各种豆制品、榨取豆油、酿造酱油和提取蛋白质。', N'File/Uploads/soya bean.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (27, N'gumbo', N'热量(千卡) 37 硫胺素(毫克) 0.05 钙(毫克) 45 蛋白质(克) 2 核黄素(毫克) 0.09 镁(毫克) 29 脂肪(克) 0.1 烟酸(毫克) 1 铁(毫克) 0.1 碳水化合物(克) 7.1 维生素C(毫克) 4 锰(毫克) 0.28 膳食纤维(克) 3.9 维生素E(毫克) 1.03 锌(毫克) 0.23 维生素A(微克) 52 胆固醇(毫克) 0 铜(毫克) 0.07 胡罗卜素(微克) 0.7 钾(毫克) 95 磷(毫克) 65 视黄醇当量(微克) 86.2 钠(毫克) 3.9 硒(微克) 0.51', N' 咖啡黄葵（学名：Abelmoschus esculentus (Linn.)Moench）亦称黄秋葵，是锦葵科一年生草本植物。茎圆柱形，疏生散刺。叶掌状，裂片阔至狭，托叶线形，被疏硬毛。花单生于叶腋间，花梗疏被糙硬毛，小苞片钟形；花萼钟形，密被星状短绒毛；花黄色，内面基部紫色，蒴果筒状尖塔形，种子球形，具毛脉纹。花期5-9月。 咖啡黄葵性喜温暖，原产地印度，广泛栽培于热带和亚热带地区。中国湖南、湖北、广东等省栽培面积也极广。 素有蔬菜王之称，有极高的经济用途和食用等价值。', N'File/Uploads/gumbo.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (28, N'luffa', N'热量(千卡) 20 硫胺素(毫克) 0.02 钙(毫克) 14 蛋白质(克) 1 核黄素(毫克) 0.04 镁(毫克) 11 脂肪(克) 0.2 烟酸(毫克) 0.4 铁(毫克) 0.4 碳水化合物(克) 3.6 维生素C(毫克) 5 锰(毫克) 0.06 膳食纤维(克) 0.6 维生素E(毫克) 0.22 锌(毫克) 0.21 维生素A(微克) 15 胆固醇(毫克) 0 铜(毫克) 0.06 胡罗卜素(微克) 0.3 钾(毫克) 115 磷(毫克) 29 视黄醇当量(微克) 94.3 钠(毫克) 2.6 硒(微克) 0.86', N' 丝瓜（学名：Luffa cylindrica (L.) Roem. ）葫芦科一年生攀援藤本；茎、枝粗糙，有棱沟，被微柔毛。卷须稍粗壮，被短柔毛，通常2-4歧。叶柄粗糙，近无毛；叶片三角形或近圆形，通常掌状5-7裂，裂片三角形上面深绿色，粗糙，有疣点，下面浅绿色，有短柔毛，脉掌状，具白色的短柔毛。雌雄同株。雄花通常15-20朵花，生于总状花序上部；雄蕊通常5，花初开放时稍靠合，最后完全分离。雌花单生，花梗长2-10厘米；子房长圆柱状，有柔毛，柱头膨大。果实圆柱状，直或稍弯，表面平滑，通常有深色纵条纹，未熟时肉质，成熟后干燥，里面呈网状纤维。种子多数，黑色，卵形，平滑，边缘狭翼状。花果期夏、秋季。 中国南、北各地普遍栽培。也广泛栽培于世界温带、热带地区。云南南部有野生，但果较短小。 果为夏季蔬菜，成熟时里面的网状纤维称丝瓜络，可代替海绵用作洗刷灶具及家具；还可供药用，有清凉、利尿、活血、通经、解毒之效。', N'File/Uploads/luffa.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (29, N'garlic', N'热量(千卡) 126 硫胺素(毫克) 0.04 钙(毫克) 39 蛋白质(克) 4.5 核黄素(毫克) 0.06 镁(毫克) 21 脂肪(克) 0.2 烟酸(毫克) 0.6 铁(毫克) 1.2 碳水化合物(克) 26.5 维生素C(毫克) 7 锰(毫克) 0.29 膳食纤维(克) 1.1 维生素E(毫克) 1.07 锌(毫克) 0.88 维生素A(微克) 5 胆固醇(毫克) 0 铜(毫克) 0.22 胡罗卜素(微克) 1.1 钾(毫克) 302 磷(毫克) 117 视黄醇当量(微克) 66.6 钠(毫克) 19.6 硒(微克) 3.09', N'  大蒜（英文名称Garlic；拉丁名称Allium sativum L.），为百合科（Liliaceae）葱属（Allium）植物的地下鳞茎。大蒜整棵植株具有强烈辛辣的蒜臭味，蒜头、蒜叶（青蒜或蒜苗）和花薹（蒜薹）均可作蔬菜食用，不仅可作调味料，而且可入药，是著名的食药两用植物。 大蒜鳞茎中含有丰富的蛋白质、低聚糖和多糖类、另外还有脂肪、矿物质等 。大蒜具有多方面的生物活性，如防治心血管疾病、抗肿瘤及抗病原微生物等，长期食用可起到防病保健作用。', N'File/Uploads/garlic.jpg')
GO
INSERT [dbo].[T_FoodNutrition] ([id], [FoodName], [NutritionalIngredient], [Introduce], [Images]) VALUES (30, N'bamboo shoots', N'热量(千卡) 19 硫胺素(毫克) 0.08 钙(毫克) 9 蛋白质(克) 2.6 核黄素(毫克) 0.08 镁(毫克) 1 脂肪(克) 0.2 烟酸(毫克) 0.6 铁(毫克) 0.5 碳水化合物(克) 1.8 维生素C(毫克) 5 锰(毫克) 1.14 膳食纤维(克) 1.8 维生素E(毫克) 0.05 锌(毫克) 0.33 维生素A(微克) 0 胆固醇(毫克) 0 铜(毫克) 0.09 胡罗卜素(微克) 0.8 钾(毫克) 389 磷(毫克) 64 视黄醇当量(微克) 92.8 钠(毫克) 0.4 硒(微克) 0.04', N' 竹笋，禾本科竹亚科多年生常绿植物，原产中国。  竹笋是江南美食之材，过去甚至有“居不可无竹，食不可无笋”之说。虽然所有竹都有竹笋生成，但并非所有竹笋都能称为烹饪之品。作为蔬菜型竹笋，必须具备组织柔嫩、无苦味或其它恶味，或虽稍带苦味，经加工除苦后可以食用的条件。', N'File/Uploads/bamboo shoots.jpg')
GO
SET IDENTITY_INSERT [dbo].[T_FoodNutrition] OFF
GO
SET IDENTITY_INSERT [dbo].[T_NutrientInformation] ON 
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (1, N'能量', N'热量', N'千卡', NULL, NULL, NULL, NULL, NULL, NULL)
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (2, N'蛋白质', N'', N'克', N'蛋白质（protein）是生命的物质基础，是有机大分子，是构成细胞的基本有机物，是生命活动的主要承担者。没有蛋白质就没有生命。氨基酸是蛋白质的基本组成单位。它是与生命及与各种形式的生命活动紧密联系在一起的物质。机体中的每一个细胞和所有重要组成部分都有蛋白质参与。蛋白质占人体重量的16%~20%，即一个60kg重的成年人其体内约有蛋白质9.6~12kg。人体内蛋白质的种类很多，性质、功能各异，但都是由20多种氨基酸（Amino acid）按不同比例组合而成的，并在体内不断进行代谢与更新。', N'蛋白质缺乏在成人和儿童中都有发生，但处于生长阶段的儿童更为敏感。蛋白质的缺乏常见症状是代谢率下降，对疾病抵抗力减退，易患病，远期效果是器官的损害，常见的是儿童的生长发育迟缓、营养不良、体质量下降、淡漠、易激怒、贫血以及干瘦病或水肿，并因为易感染而继发疾病。蛋白质的缺乏，往往又与能量的缺乏共同存在即蛋白质—热能营养不良，分为两种，一种指热能摄入基本满足而蛋白质严重不足的营养性疾病，称加西卡病。另一种即为“消瘦”，指蛋白质和热能摄入均严重不足的营养性疾病。', N'蛋白质如果摄取过量的话也会在体内转化成脂肪，造成脂肪堆积。肾脏要排泄进食的蛋白质，当分解蛋白质时会产生大量的氮素这样会增加肾脏的负担。蛋白质，尤其是动物性蛋白摄入过多，对人体同样有害。首先过多的动物蛋白质的摄入，就必然摄入较多的动物脂肪和胆固醇。其次蛋白质过多本身也会产生有害影响。正常情况下，所以必须将过多的蛋白质脱氨分解，氮则由尿排出体外，这加重了代谢负担，而且，这一过程需要大量水分，从而加重了肾脏的负荷，若肾功能本来不好，则危害就更大。过多的动物蛋白摄入，也造成含硫氨基酸摄入过多，这样可加速骨骼中钙质的丢失，易产生骨质疏松。', N'要保证有足够数量和质量的蛋白质食物．根据营养学家研究，一个成年人每天通过新陈代谢大约要更新300g以上蛋白质，其中3/4来源于机体代谢中产生的氨基酸，这些氨基酸的再利用大大减少了需补给蛋白质的数量．一般地讲，一个成年人每天摄入60g～80g蛋白质，基本上已能满足需要。', N'老年人、幼儿、运动员、孕产妇', N'蛋白质的主要来源，分为动物性蛋白质、植物性蛋白质。一般来说，动物蛋白质的营养价值比植物蛋白质高。 奶类：如牛奶、羊奶、马奶等； 畜肉：如牛、羊、猪肉等； 禽肉：如鸡、鸭、鹅、鹌鹑、鸵鸟等； 蛋类：如鸡蛋、鸭蛋、鹌鹑蛋等 鱼、虾、蟹等；还有大豆类，包括黄豆、大青豆和黑豆等，其中以黄豆的营养价值最高，它是婴幼儿食品中优质的蛋白质来源；此外像芝麻、瓜子、核桃、杏仁、松子等干果类的蛋白质的含量均较高。')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (3, N'脂肪', NULL, N'克', N'脂肪是身体组织的重要成分，也是供给热量的主要原料。细胞中的原生质和细胞膜均含有脂肪化合物，食物中的脂类95％以上是甘油三酯，此外还有胆固醇脂和磷脂。', N'必需脂肪酸缺乏，可引起生长迟缓、生殖障碍、皮肤受损等；另外，还可引起肝脏、肾脏、神经和视觉等多种疾病。', N'脂肪摄入过量将产生肥胖，并导致一些慢性病的发生；膳食脂肪总量增加，还会增大某些癌症的发生几率。', N'高脂肪的食物有坚果类（花生，芝麻，开心果，核桃，松仁等）还有动物类皮肉（肥猪肉，猪油，黄油，酥油，植物油等）还有些油炸食品，面食，点心，蛋糕等等。低脂肪的食物有水果类（苹果，柠檬，等），蔬菜类（冬瓜，黄瓜，丝瓜，白萝卜，苦瓜，韭菜，绿豆芽，辣椒等），鸡肉，鱼肉，紫菜，木耳，荷叶茶，醋等等。', N'少年、儿童、孕妇', N'食用油、松子、腊肉、芝麻酱、杏仁、猪肉')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (4, N'碳水化合物', N'糖', N'克', N'碳水化合物亦称糖类化合物，是自然界存在最多、分布最广的一类重要的有机化合物。主要由碳、氢、氧所组成。葡萄糖、蔗糖、淀粉和纤维素等都属于糖类化合物。', N'膳食中缺乏碳水化合物将导致全身无力，疲乏、血糖含量降低，产生头晕、心悸、脑功能障碍等。严重者会导致低血糖昏迷。', N'当膳食中碳水化合物过多时，就会转化成脂肪贮存于身体内，使人过于肥胖而导致各类疾病如高血脂、糖尿病等。', N'糖类、谷物（如水稻、小麦、玉米、大麦、燕麦、高粱等）、水果（如甘蔗、甜瓜、西瓜、香蕉、葡萄等）、干果类、干豆类、根茎蔬菜类（如胡萝卜、番薯等）等。', N'儿童、青少年、中年、老年人', N'面条、馒头、面包、甘薯、米饭、玉米片、南瓜、西瓜、土豆')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (5, N'钙', NULL, N'毫克', N'钙是人体内含量最多的一种无机盐。正常人体内钙的含量为1200～1400克，约占人体重量的1.5%～2.0%，其中99%存在于骨骼和牙齿之中。另外，1%的钙大多数呈离子状态存在于软组织、细胞外液和血液中，与骨钙保持着动态平衡。机体内的钙，一方面构成骨骼和牙齿，另一方面则可参与各种生理功能和代谢过程，影响各个器官组织的活动。', N'少年儿童：厌食、偏食；不易入睡、易惊醒；易感冒；头发稀疏；智力发育迟缓；学步、出牙晚或出牙不整齐；阵发性腹痛腹泻；X或O型腿；鸡胸。 青年：精力不集中；容易疲劳；腰酸背痛；免疫力低；蛀牙或牙齿发育不良。 孕妇及哺乳期妇女：抽筋乏力；关节疼；头晕；贫血及产前高血压综合征；水肿及乳汁分泌不足。 老年人：老年性皮肤病痒；脚后跟疼，腰椎、颈椎疼痛；牙齿松动、脱落；明显的驼背、身高降低；食欲减退、消化道溃疡；多梦、失眠、烦躁、易怒等。', N'1、补钙过量增加骨质疏松风险 2、补钙过量增加结石病风险 3、补钙过量增加心脏损伤风险 4、补钙过量影响矿物质吸收 5、出现高钙血症 6、胃肠道不良反应', N'牛奶、酸奶、奶酪、虾 皮、海产品、芝麻、芝麻酱、大豆、豆制品。 良好来源：鸡蛋、绿叶蔬菜、硬果、食用菌藻类、鱼粉、鱼松等。', N'幼儿、青少年、孕妇、更年期妇女、老年人', N'奶及奶制品、豆类、坚果、木耳、虾皮、海带、发菜、芝麻酱')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (6, N'钠', NULL, N'毫克', N'钠和钾是同时被发现的元素，两者是正常生长发育中不可或缺的物质。钠可使钙(钙食品)和其他矿物质溶于血液之中，于新陈代谢息息相关。', N'钠缺乏症可造成生长缓慢、食欲减退、由于失水体重减轻、哺乳期的母亲奶水减少、肌肉痉挛、恶心、腹泻和头痛。此外，过多出汗和盐量不足可同时使热能耗尽，在这种情况下，应服用盐片和补充大量水分。', N'膳食中长期摄入过多的钠将导致高血压，如果误将食盐当作食糖给婴幼儿食用，有可能导致死亡。', N'膳食中的钠主要存在于食盐中，它是烹饪中重要的调味品，也是保证肌体水份平衡的最重要物质，没有食盐，人的生存将受到障碍。食盐在防止食品腐败上有重要作用，钠是构成食盐的不可缺少的成份。', N'乳母、老年人', N'食盐、酱油、盐渍品、腌制肉类、酱咸菜类、发酵豆制品、咸味休闲食品')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (7, N'镁', NULL, N'毫克', N'镁是维持人体生命活动的必需元素，具有调节神经和肌肉活动、增强耐久力的神奇功能。', N'镁缺乏可致血清钙下降，神经肌肉兴奋性亢进;对血管功能可能有潜在的影响，有人报告低镁血症患者可有房室性早搏、房颤以及室速与室颤，半数有血压升高;同时，镁缺乏可能是绝经后骨质疏松症的一种危险因素;', N'过量镁摄入，血清镁在1.5-2.5mmol/L时，常伴有恶心、胃肠痉挛等胃肠道反应;当血清镁增高到2.5-3.5mmol/L时则出现嗜睡、肌无力、膝腱反射弱、肌麻痹;但血清镁增至5mmol/L时，深腱反射消失;血清镁超过5mmol/L时可发生随意肌或呼吸肌麻痹;血清镁7.5mmol/L或更高时可以发生心脏完全传导阻滞或心搏停止。 高镁血症可引起低血钙，其部分机制可能是由于甲状旁腺素分泌降低或靶器官对激素的反应性降低。高镁血症可影响骨和血液凝固。在尿毒症时，骨中镁含量显著增高。更重要的是镁过多可致骨异常。镁过多可干扰血小板粘附和凝血酶原生成时间。尿毒症时凝血障碍部分原因可能是由于慢性高镁血症所致。', N'海参、榛子、西瓜子、鲍鱼、燕麦片、小茴香、小米、苋菜、葵花子、虾皮、砖茶、绿茶、花茶、海蜇皮、黄豆、木耳、海米、咖啡、可可粉、棉籽粉、花生粉、黑芝麻、大豆粉。 良好来源有松子、绿豆、青豆、芸豆、口蘑、海带、豆腐粉、小豆、黑米、香菇(香菇食品)、蚕豆、莲子、干贝、姜、金针菜、豌豆、坚果、花生酱、全谷物(如小麦、大麦和燕麦等)。 一般来源有香蕉、牛肉、面包、玉米、鱼及海产品、猪肉及大多数绿叶蔬菜(蔬菜食品)。 微量来源有卷心菜、茄子、蛋类、动植物油(油食品)脂、冰淇淋、大多数水果(水果食品)、糖和香肠等。', N'中年、更年期妇女、老年人', N'大麦、黑米、荞麦、麸皮、黄豆、苋菜、口蘑、干木耳、干香菇、干苔菜')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (8, N'铁', NULL, N'毫克', N'铁是血红蛋白的组成成分，与氧结合，运输到身体的每一个部分，供人们呼吸氧化，以提供能量(能量食品)，消化(消化食品)食物，获得营养;人体内的肌红蛋白存在于肌肉之中，含有亚铁血红素，也结合着氧，是肌肉中的“氧库”。当运动(运动食品)时肌红蛋白中的氧释放出来，随时供应肌肉活动所需的氧。心、肝、肾这些具有高度生理活动能力和生化功能的细胞线粒体内，储存的铁特别多，线粒体是细胞的“能量工厂”，铁直接参与能量的释放。 [2] 铁还可以促进发育，增加对疾病的抵抗力，调节组织呼吸，防止疲劳，构成血红素，预防和治疗因缺铁而引起的贫血，使皮肤恢复良好的血色。 成人体内约有4～5克铁，其中72%以血红蛋白、35%以肌红蛋白、0.2以其它化合物形式存在，其余为储备铁。储备铁约占25%，主要以铁蛋白的形式储存在肝、脾和骨髓中。成人摄取量是10～15mg。妊娠期妇女需要30mg。', N'1、贫血：严重时可增加儿童和母亲死亡率，使机体工作能力明显下降。 2、行为和智力方面：铁缺乏可引起心理活动和智力发育的损害及行为改变。铁缺乏（尚未出现贫血时的缺乏）还可损害儿童的认知能力，而且在以后补充铁后也难以恢复。', N'1 铁在人体内贮存过多，因而可引致铁在体内潜在的有害作用，体内铁的贮存过多与多种疾病如心脏和肝脏疾病、糖尿病、某些肿瘤有关。 2 食物中摄铁过多，使体内铁量超过正常的10～20倍，就可能出现慢性中毒症状：肝、脾有大量铁沉着，可表现为肝硬化、骨质疏松、软骨钙(钙食品)化、皮肤呈棕黑色或灰暗、胰岛素分泌减少而导致糖尿病(糖尿病食品)。', N'铁(铁食品)的丰富来源有牛肾、鱼子酱、鸡内脏、可可粉、鱼粉、肝脏、土豆、精白米、黄豆粉、麦糠、麦胚和小麦黄豆混合粉。 良好来源有牛肉、红糖、蛤肉、干果、蛋黄、猪和羊肾脏。 良好来源：瘦肉、红糖、蛋黄、猪肾、羊肾、干果（杏干、葡萄干），啤酒酵母菌、海草、赤糖糊及麦。 一般来源：鱼、谷物、菠菜、扁豆、豌豆、芥菜叶、蚕豆、瓜子（南瓜、西葫芦等种子） 微量来源：奶制品、蔬菜各水果 此外用铸铁锅煮番茄或其它酸性食物，也可增添铁质，锅会把有益于健康的铁深入食物内。', N'妇女、孕妇、儿童、老人', N'苔菜(干) 283.7 毫克 普中红蘑(干) 235.1 毫克 猪胆肝 181.3 毫克 口蘑(干) 137.5 毫克 木耳(干) 97.4 毫克 发菜(干) 85.2 毫克 菊花[怀菊花] 78 毫克 紫菜(干) 54.9 毫克 芝麻酱 50.3 毫克 鸭肝(母麻鸭) 50.1 毫克 桑葚(干) 42.5 毫克 青稞 40.7 毫克 鸭血 39.6 毫克 芥菜干 39.3 毫克 猪肝 22.9 毫克 芝麻籽(黑) 22.7 毫克 菠菜(脱水) 25.9 毫克 豆腐干(小香干) 23.3 毫克')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (9, N'碘', NULL, N'微克', N'碘在体内主要参与甲状腺素的合成，其生理作用也是通过甲状腺素的作用表现出来。至今尚未发现碘的独立功能。甲状腺素调节和存进代谢，与生长发育关系密切。', N'机体因缺碘导致的一系列疾病以前命名为地方性甲状腺肿和地方性克汀病,现在统称为碘缺乏病。', N'碘过量可导致甲状腺功能减退症、自身免疫甲状腺病和乳头状甲状腺癌的发病率显著增加。', N'碘主要来自海产品,如海带、紫菜、海蜇、带鱼等。', N'青少年、孕妇、老年人', N'裙带菜（干）、紫菜（干）、海带（鲜）、鸡精、虾皮、虾酱、虾米、豆腐干。')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (10, N'锌', NULL, N'毫克', N'锌是人体不可缺少的微量元素，补锌可以促进儿童身体及智力发育。专家进一步指出，年龄为12岁至13岁儿童补锌最有利于提高其智力，此时补锌等于补智。 锌元素主要存在于海产品、动物内脏中,其它食物里含锌量很少水、主食类食物以及孩子们爱吃的蛋类里几乎都没有锌,含有锌的蔬菜和水果也不是很多。', N'儿童 味觉障碍：厌食、偏食或异食； 皮肤疾患：易患口腔溃疡，受损伤口不易愈合，青春期痤疮等； 生长发育不良：身材矮小、瘦弱； 免疫力下降，经常感冒、发烧； 智力发育落后； 肝脾肿大 孕妇 妊娠反应加重：嗜酸，呕吐加重 宫内胎儿发育迟缓：导致早产儿、低体重儿 分娩合并症增多：产程延长、流产、早产、胎儿畸形率增高：脑部中枢神经系统畸形 肝脾肿大 成年男性 男性不育：少精、弱精或精液不液化、男性前列腺炎、 肝脾肿大', N'吸入会引起口渴、胸部紧束感、干咳、头痛、头晕、高热、寒战等。粉尘对眼有刺激性。口服刺激胃肠道。长期反复接触对皮肤有刺激性。', N'瘦肉、猪肝、鱼类、蛋黄等。其中以牡蛎含锌最为高。据化验，动物性食品含锌量普遍较多，每一百克动物性食品中大约含锌3—5毫克，并且动物性蛋白质分解后所产生的氨基酸还能促进锌的吸收。植物性食品中锌较少。每一百克植物性食品中大约含锌1毫克。各种植物性食物中含锌量比较高的有豆类、花生、小米、萝卜、大白菜等。', N'儿童、孕妇、成年男性、皮肤病患者', N'生蚝 71.2 小麦胚粉 23.4 山核桃 12.6 扇贝(鲜) 11.7 口蘑 9.04 香菇(干) 8.47 羊肉(瘦) 6.06 葵花子(炒) 5.91 猪肚 5.78 牛肝 5.01')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (11, N'硒', NULL, N'微克', N'硒是人体必需的微量元素。中国营养学会也将硒列为人体必需的15种营养素之一，国内外大量临床实验明，人体缺硒可引起某些重要器官的功能失调，导致许多严重疾病发生。', N'1、缺乏硒会导致未老先衰。 2、严重缺乏硒会引发心肌病及心肌衰竭。 3、发生克山病，大骨节病。 4、精神萎靡不振，精子活力下降，易患感冒。', N'慢性硒中毒往往是由于每天从食物中摄取硒2400～3000微克，长达数月之久才出现症状。表现为脱发、脱指甲、皮肤黄染、口臭、疲劳、龋齿易感性增加、抑郁等。一般慢性硒中毒都有头晕、头痛、倦怠无力、口内金属味、恶心、呕吐、食欲不振、腹泻、呼吸和汗液有蒜臭味，还可有肝肿大、肝功能异常，自主神经功能紊乱，尿硒增高。长期高硒使小儿身长、体重发育迟缓，毛发粗糙脆弱，甚至有神经症状及智能改变。慢性硒中毒的主要特征是脱发及指甲形状的改变。', N'有芝麻、动物内脏、大蒜(大蒜食品)、蘑菇、海米、鲜贝、淡菜、金针菇、海参、鱿鱼、苋菜、鱼粉、黄油(油食品)、啤酒酵母、小麦胚和龙虾。良好来源有海蟹、干贝、带鱼、松花鱼、黄鱼、龙虾、羊油、豆油、猪肾脏、全小麦粒(粉)、螃蟹、猪肉和羊肉。一般来源有小茴香、冬菇、桃酥、红萝卜、全燕麦粉、啤酒、大米、橘汁和全脂牛奶。微量来源有玉米、小米、核桃、奶油蛋糕、油饼、水果(水果食品)和糖。', N'儿童、癌症患者、糖尿病患者、孕妇、乳母', N'魔芋精粉 350.15 (微克) 鲑鱼籽酱 203.09 (微克) 猪肾(腰子) 156.77 (微克) 鱿鱼(干) 156.12 (微克) 海参(干) 150 (微克) 贻贝(干) 120.47 (微克) 猪肾[猪腰子 111.77 (微克) 墨鱼(干 ) 104.4 (微克) 松蘑(干) 98.44 (微克) 15牡蛎[海蛎子] 86.64 (微克) 海蟹 82.65 (微克) 堤鱼 80.36 (微克) 香海螺 79.2 (微克) 赤眼鳟[金目鱼] 78.76 (微克) 花蛤蜊 77.1 (微克) 扇贝(干) 76.35 (微克) 虾米 75.4 (微克) 红螺 74.78 (微克) 虾皮 74.43 (微克) 花豆(紫) 74.06 (微克)')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (12, N'胡萝卜素', N'Carotene', N'微克', N'胡萝卜中含有大量的β-胡萝卜素，摄入人体消化器官后，可以转化成维生素A，是目前最安全补充维生素A的产品 （单纯补充化学合成维生素A，过量时会使人中毒）。它可以维持眼睛和皮肤的健康，改善夜盲症、皮肤粗糙的状况，有助于身体免受自由基的伤害。不宜与醋等酸性物质同时服用. 1、维持皮肤粘膜层的完整性，防止皮肤干燥，粗糙； 2、构成视觉细胞内的感光物质； 3、促进生长发育，有效促进健康及细胞发育，预防先天不足。促进骨骼及牙齿健康成长； 4、维护生殖功能； 5、维持和促进免疫功能。数据介绍，胡萝卜具有预防和抑制肺癌的作用。', N'1、暗适应能力下降，夜盲及干眼病； 2、粘膜、上皮改变； 3、生长发育受阻； 4、味觉、嗅觉减弱，食欲下降； 5、头发枯干、皮肤粗糙、记忆力减退、心情烦躁及失眠。', N'1、急性维生素A中毒：成人一次剂量超过90-~300mg（30-100万IU），儿童一次剂量超过90mg（30万IU）即可发生急性中毒，主要表现为嗜睡或过度兴奋、头痛、呕吐等高颅压症状，12~20小时后出现皮肤红肿，继而脱皮，以手掌、脚底等厚处最为明显，数周后方恢复正常。 2、慢性维生素A中毒：成人每天摄入24-30mg，持续半年；或每天9-12mg，超过8年可引起慢性中毒。婴幼儿每天摄入15~30mg，超过6个月即可引起慢性中毒。主要表现为胃纳减退，体重下降，继而有皮肤干燥，脱屑，皲裂，毛发干枯，脱发，齿龈红肿，唇干裂和鼻出血等皮肤粘膜损伤现象，以及长骨肌肉连接处疼痛伴肿胀，体检可见贫血，脾脏肿大。', N'胡萝卜素主要存在于深绿色或红黄色的蔬菜和水果中，如：胡萝卜、西兰花、菠菜、空心菜、甘薯、芒果、哈密瓜、杏及甜瓜等，大体上，越是颜色强烈的水果或蔬菜，含β-胡萝卜素越丰富。 深色蔬菜可以焯着吃，也可以炖着吃。深色蔬菜因含热量、蛋白质极少，所以在做菜或食用时，最好能和肉、鱼、蛋搭配，并和米饭、面包等谷物食品一起吃。', N'孕妇、孕早期、产妇', N'每100克食品中 螺旋藻： 38810微克 枸杞子： 9750 微克 西兰花： 7210 微克 绿茶: 5800 微克 胡萝卜： 4130 微克 沙棘果： 3840 微克 芒果： 897 微克 番茄： 375 微克')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (13, N'维生素A', N'视黄醇', N'微克', N'维生素A的化学名为视黄醇，是最早被发现的维生素。具有调节表皮及角质层新陈代谢的功效，可以抗衰老，去皱纹。有助于保护表皮，黏膜不受细菌侵害，健康皮肤，预防皮肤癌。 预防夜盲症，视力衰退，治疗各种眼疾，使女人明眸善睐。 促进骨骼生长，帮助牙齿生长，再生。有效预防肥胖，保持女性苗条的身材。可有助于防治脱发。', N'患维生素A缺乏[1]病常有营养不良、慢性腹泻、慢性痢疾、麻疹后长期忌嘴，畏光、不明眨眼等合并症。年长儿皮肤会有干燥、毛囊角化等改变。早期及非典型的病例，眼部的变化较轻，特别在婴幼儿期容易被忽略。若食物中维生素A缺乏或有吸收障碍，可在数星期内出现症状。婴儿患先天性胆道梗阻、肝炎综合征，若并发肺炎则可在短时间内出现眼干燥症。', N'由于维生素A可以在脂肪中储存，过量摄入维生素A会造成蓄积性毒性，β胡萝卜素则没有这种危险，即使服用非常大的剂量也不会引起严重的副作用。但长期服用β胡萝卜素应该同时补充维生素E和叶黄素，因为β胡萝卜素会降低二者在人体内的水平。', N'黄色水果如柑桔及黄、绿色蔬菜中均含有β胡萝卜素，动物脂肪如蛋黄及肝脏中含有一定的维生素A。此外，鱼肝油也是维生素A的良好来源', N'婴幼儿、青少年、孕妇、乳母、老年人', N'鱼肝油、羊肝、牛肝、鸡肝、猪肝、鸭蛋黄、胡萝卜、菠菜、鸡蛋黄、荠菜')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (14, N'维生素B1', N'硫胺素', N'毫克', N'维生素B1主要治疗维生素B1缺乏的预防和治疗，如“脚气病”，周围神经炎及消化不良。妊娠或哺乳期，甲状腺功能亢进，烧伤，长期慢性感染，重体力劳动，吸收不良综合症伴肝胆疾病，小肠系统疾病及胃切除后维生素B1的补充。', N'维生素B1缺乏可引起脚气病。临床上根据年龄差异分为成人脚气病和婴儿脚气病。', NULL, N'维生素B1广泛存在于天然食物中，最为丰富的来源是葵花籽仁、花生、大豆粉、瘦猪肉；其次为小麦粉、小米、玉米、大米等谷类食物；鱼类、蔬菜和水果中含量较少。建议食用碾磨度不太精细的谷物，可防治维生素B1缺乏。', N'婴幼儿、孕妇、乳母、老年人', N'葵花籽仁、花生仁、瘦猪肉、大豆、蚕豆、小米、麸皮、小麦粉、玉米、稻米、猪肝、鸡蛋')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (15, N'维生素B2', N'核黄素', N'毫克', N'维生素B2又叫核黄素，微溶于水，在中性或酸性溶液中加热是稳定的。体内维生素B2的储存是很有限的，因此每天都要由饮食提供。', N'维生素B2的欠缺会导致口腔、唇、皮肤、生殖器的炎症和机能障碍，称为核黄素缺乏病；长期缺乏会导致儿童生长迟缓，轻中度缺铁性贫血；严重缺乏时常伴有其它B族维生素缺乏症状。', N'维生素B2是水溶性维生素，虽然摄入过量会从尿液中排出，但并不能说过量服用维生素B2对人体没有任何副作用。', N'动物肝脏、鸡蛋、牛奶、豆类及某些蔬菜，如雪里红、油菜、菠菜、青蒜等绿叶蔬菜都能提供维生素B2。 动物内脏含维生素B2很丰富，尤其是肝脏含量最高。每天只要食用这些内脏50～100克，就可满足儿童、少年一天的维生素B2的需要。其他动物性食物如猪肉、鸡蛋，水产品中的鳝鱼、河蟹等也都含有较多的维生素B2。', N'婴幼儿、孕妇、乳母、糖尿病人', N'奶类及其制品、动物肝脏与肾脏、蛋黄、鳝鱼、菠菜、胡萝卜、酿造酵母、香菇、紫菜、茄子')
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (16, N'维生素B6', N'吡哆素', N'毫克', NULL, NULL, NULL, NULL, NULL, NULL)
GO
INSERT [dbo].[T_NutrientInformation] ([id], [Name], [OtherName], [Unit], [Introduction], [DeSymptom], [MuchHarm], [Source], [FocusGroups], [HighContentOfSource]) VALUES (18, N'盐', N'Nacl', N'克', NULL, NULL, NULL, NULL, NULL, NULL)
GO
SET IDENTITY_INSERT [dbo].[T_NutrientInformation] OFF
GO
USE [master]
GO
ALTER DATABASE [DietaryNutrition] SET  READ_WRITE 
GO
