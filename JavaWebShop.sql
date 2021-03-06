USE [FUD]
GO
/****** Object:  Table [dbo].[CartDetailId]    Script Date: 1/2/2021 11:21:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CartDetailId](
	[CartDetailId] [int] NOT NULL,
	[CartId] [int] NULL,
	[ProductId] [int] NULL,
	[Quantity] [int] NULL,
	[Price] [float] NULL,
	[Note] [nvarchar](200) NULL,
 CONSTRAINT [PK_CartDetailId] PRIMARY KEY CLUSTERED 
(
	[CartDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Carts]    Script Date: 1/2/2021 11:21:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts](
	[CartId] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [int] NULL,
	[CreatedDate] [date] NULL,
	[Status] [nchar](30) NULL,
 CONSTRAINT [PK_Carts] PRIMARY KEY CLUSTERED 
(
	[CartId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 1/2/2021 11:21:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_Categories] PRIMARY KEY CLUSTERED 
(
	[CategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 1/2/2021 11:21:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[CustomerId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Gender] [bit] NOT NULL,
	[DayOfBirth] [date] NULL,
	[Email] [nvarchar](50) NULL,
	[Phone] [varchar](30) NULL,
	[Status] [varchar](20) NULL,
	[Password] [varchar](30) NOT NULL,
	[RegisteredDate] [date] NOT NULL,
 CONSTRAINT [PK_Customers_1] PRIMARY KEY CLUSTERED 
(
	[CustomerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 1/2/2021 11:21:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductId] [int] IDENTITY(1,1) NOT NULL,
	[CategoryId] [int] NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Price] [float] NOT NULL,
	[Status] [nvarchar](30) NULL,
	[ManufacturedDate] [date] NULL,
	[Description] [ntext] NULL,
	[Image] [nvarchar](250) NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (1, N'Computer')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (2, N'Monitor')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (3, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (4, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (5, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (6, N'nguyen')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (7, N'nguyen')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (8, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (9, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (10, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (11, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (12, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (13, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (14, N'Test')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (15, N'aaaa aaaa')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (16, N'aaaaaaaaaaaaa')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (17, N'5')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (18, NULL)
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (19, N'Nguyen Aaaaaaa')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (20, N'Nguyen Aaaaaaa')
INSERT [dbo].[Categories] ([CategoryId], [Name]) VALUES (21, N'Test')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([ProductId], [CategoryId], [Name], [Quantity], [Price], [Status], [ManufacturedDate], [Description], [Image]) VALUES (2, 1, N'HP EliteBook', 12, 300, N'InStock', CAST(N'2020-12-29' AS Date), N'HP Computer', N'HP-Elite-840-g3.jpg')
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
ALTER TABLE [dbo].[CartDetailId]  WITH CHECK ADD  CONSTRAINT [FK_CartDetailId_Carts] FOREIGN KEY([CartId])
REFERENCES [dbo].[Carts] ([CartId])
GO
ALTER TABLE [dbo].[CartDetailId] CHECK CONSTRAINT [FK_CartDetailId_Carts]
GO
ALTER TABLE [dbo].[CartDetailId]  WITH CHECK ADD  CONSTRAINT [FK_CartDetailId_Products] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([ProductId])
GO
ALTER TABLE [dbo].[CartDetailId] CHECK CONSTRAINT [FK_CartDetailId_Products]
GO
ALTER TABLE [dbo].[Carts]  WITH CHECK ADD  CONSTRAINT [FK_Carts_Customers] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[KhachHang] ([CustomerId])
GO
ALTER TABLE [dbo].[Carts] CHECK CONSTRAINT [FK_Carts_Customers]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Categories] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([CategoryId])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Categories]
GO
