--Product
CREATE TABLE Product
(
    product_id         int identity
        primary key,
    product_name       nvarchar(128) not null,
    category           varchar(32)   not null,
    image_url          varchar(256)  not null,
    price              int           not null,
    stock              int           not null,
    description        nvarchar(1024),
    created            datetime      not null,
    last_modified_date datetime      not null
)

--User
CREATE TABLE [Users]
(
    user_id             INT             NOT NULL PRIMARY KEY IDENTITY(1,1),
    email               VARCHAR(256)    NOT NULL UNIQUE,
    password            VARCHAR(256)    NOT NULL,
    created_date        DATETIME        NOT NULL,
    last_modified_date  DATETIME        NOT NULL
    );

SELECT * FROM Product

Order By product_id
OFFSET 10 ROWS


-- Demo Products
    INSERT INTO Product (product_name, category, image_url, price, stock, description, created, last_modified_date)
VALUES
-- [ 3C 電子產品 ]
    ('iPhone 15 Pro', 'ELECTRONICS', 'https://example.com/img/iphone15.jpg', 36900, 50, 'Apple 最新旗艦手機', '2023-10-01 10:00:00', '2023-10-05 12:00:00'),
    ('MacBook Air M2', 'ELECTRONICS', 'https://example.com/img/macbook.jpg', 35900, 30, '輕薄筆電的首選', '2023-10-02 11:30:00', '2023-10-06 14:20:00'),
    ('AirPods Pro 2', 'ELECTRONICS', 'https://example.com/img/airpods.jpg', 7490, 100, '主動降噪真無線耳機', '2023-10-03 09:15:00', '2023-10-04 09:15:00'),
    ('iPad Air 5', 'ELECTRONICS', 'https://example.com/img/ipad.jpg', 19900, 45, '搭載 M1 晶片的平板電腦', '2023-10-04 15:40:00', '2023-10-08 10:00:00'),
    ('Samsung Galaxy S23', 'ELECTRONICS', 'https://example.com/img/s23.jpg', 26900, 60, '安卓旗艦智慧型手機', '2023-10-05 16:20:00', '2023-10-07 11:00:00'),
    ('Sony WH-1000XM5', 'ELECTRONICS', 'https://example.com/img/sony_wh.jpg', 11900, 25, '頂級降噪耳罩式耳機', '2023-10-06 14:10:00', '2023-10-09 13:00:00'),
    ('Logitech MX Master 3S', 'ELECTRONICS', 'https://example.com/img/mx_master.jpg', 3990, 80, '人體工學高階滑鼠', '2023-10-07 10:00:00', '2023-10-10 09:30:00'),
    ('Keychron K2', 'ELECTRONICS', 'https://example.com/img/keychron.jpg', 2990, 40, '無線機械式鍵盤', '2023-10-08 08:45:00', '2023-10-11 08:45:00'),
    ('Nintendo Switch OLED', 'ELECTRONICS', 'https://example.com/img/switch.jpg', 10480, 120, 'OLED版任天堂遊戲機', '2023-10-09 17:30:00', '2023-10-12 15:00:00'),
    ('PS5 Console', 'ELECTRONICS', 'https://example.com/img/ps5.jpg', 17580, 15, '次世代遊戲主機', '2023-10-10 12:00:00', '2023-10-13 14:00:00'),
    ('ASUS ROG Zephyrus', 'ELECTRONICS', 'https://example.com/img/rog.jpg', 45900, 10, '高階電競筆電', '2023-10-11 11:11:00', '2023-10-14 10:10:00'),
    ('GoPro HERO 12', 'ELECTRONICS', 'https://example.com/img/gopro.jpg', 14900, 55, '極限運動攝影機', '2023-10-12 09:20:00', '2023-10-15 08:20:00'),
    ('Kindle Paperwhite', 'ELECTRONICS', 'https://example.com/img/kindle.jpg', 4500, 70, '電子書閱讀器', '2023-10-13 14:50:00', '2023-10-16 11:30:00'),
    ('Apple Watch Series 9', 'ELECTRONICS', 'https://example.com/img/applewatch.jpg', 13500, 85, '智慧型手錶', '2023-10-14 16:10:00', '2023-10-17 12:00:00'),
    ('Dyson Supersonic', 'ELECTRONICS', 'https://example.com/img/dyson.jpg', 14600, 35, '吹風機界的神級產品', '2023-10-15 13:40:00', '2023-10-18 09:50:00'),
    ('LG 55吋 4K 電視', 'ELECTRONICS', 'https://example.com/img/lgtv.jpg', 25900, 20, '4K 智慧聯網電視', '2023-10-16 10:30:00', '2023-10-19 14:20:00'),
    ('Google Pixel 8', 'ELECTRONICS', 'https://example.com/img/pixel8.jpg', 24900, 45, 'Google 原生手機', '2023-10-17 11:20:00', '2023-10-20 16:10:00'),
    ('小米行動電源 10000mAh', 'ELECTRONICS', 'https://example.com/img/xiaomi_pb.jpg', 495, 300, '輕薄大容量行動電源', '2023-10-18 08:15:00', '2023-10-21 09:00:00'),
    ('Anker Type-C 快充線', 'ELECTRONICS', 'https://example.com/img/anker_cable.jpg', 390, 500, '耐折彎快充傳輸線', '2023-10-19 09:45:00', '2023-10-22 10:30:00'),
    ('Razer DeathAdder V3', 'ELECTRONICS', 'https://example.com/img/razer.jpg', 2190, 65, '人體工學電競滑鼠', '2023-10-20 14:00:00', '2023-10-23 11:15:00'),

-- [ 服飾與配件 ]
    ('純棉素色短T', 'CLOTHING', 'https://example.com/img/tshirt_w.jpg', 350, 200, '舒適百搭純棉短袖', '2023-10-01 08:00:00', '2023-10-02 08:00:00'),
    ('經典直筒牛仔褲', 'CLOTHING', 'https://example.com/img/jeans.jpg', 1200, 150, '修身剪裁牛仔褲', '2023-10-02 09:30:00', '2023-10-03 09:30:00'),
    ('防風連帽外套', 'CLOTHING', 'https://example.com/img/jacket.jpg', 1850, 80, '防潑水機能外套', '2023-10-03 10:15:00', '2023-10-04 10:15:00'),
    ('純色休閒襯衫', 'CLOTHING', 'https://example.com/img/shirt.jpg', 790, 120, '上班休閒皆可穿', '2023-10-04 11:20:00', '2023-10-05 11:20:00'),
    ('運動排汗衫', 'CLOTHING', 'https://example.com/img/sport_t.jpg', 590, 180, '透氣快乾運動上衣', '2023-10-05 13:40:00', '2023-10-06 13:40:00'),
    ('保暖羽絨外套', 'CLOTHING', 'https://example.com/img/down_jacket.jpg', 2990, 50, '冬季禦寒首選', '2023-10-06 14:50:00', '2023-10-07 14:50:00'),
    ('無縫運動內衣', 'CLOTHING', 'https://example.com/img/sports_bra.jpg', 890, 100, '高包覆性運動內衣', '2023-10-07 15:30:00', '2023-10-08 15:30:00'),
    ('高腰瑜珈褲', 'CLOTHING', 'https://example.com/img/yoga_pants.jpg', 990, 110, '彈性顯瘦瑜珈長褲', '2023-10-08 16:20:00', '2023-10-09 16:20:00'),
    ('復古老帽', 'CLOTHING', 'https://example.com/img/cap.jpg', 450, 300, '百搭復古棒球帽', '2023-10-09 17:10:00', '2023-10-10 17:10:00'),
    ('羊毛混紡圍巾', 'CLOTHING', 'https://example.com/img/scarf.jpg', 690, 90, '親膚保暖冬季配件', '2023-10-10 18:00:00', '2023-10-11 18:00:00'),
    ('帆布托特包', 'CLOTHING', 'https://example.com/img/totebag.jpg', 550, 250, '大容量環保帆布包', '2023-10-11 09:00:00', '2023-10-12 09:00:00'),
    ('真皮皮帶', 'CLOTHING', 'https://example.com/img/belt.jpg', 850, 140, '質感金屬扣環皮帶', '2023-10-12 10:30:00', '2023-10-13 10:30:00'),
    ('休閒小白鞋', 'CLOTHING', 'https://example.com/img/whiteshoes.jpg', 1500, 85, '百搭人氣小白鞋', '2023-10-13 11:45:00', '2023-10-14 11:45:00'),
    ('抗UV太陽眼鏡', 'CLOTHING', 'https://example.com/img/sunglasses.jpg', 1200, 70, '偏光防紫外線墨鏡', '2023-10-14 12:15:00', '2023-10-15 12:15:00'),
    ('純棉中筒襪(3雙入)', 'CLOTHING', 'https://example.com/img/socks.jpg', 299, 400, '透氣舒適日常襪', '2023-10-15 13:20:00', '2023-10-16 13:20:00'),
    ('防水後背包', 'CLOTHING', 'https://example.com/img/backpack.jpg', 1980, 60, '適合通勤與筆電收納', '2023-10-16 14:40:00', '2023-10-17 14:40:00'),
    ('男士西裝外套', 'CLOTHING', 'https://example.com/img/blazer.jpg', 3500, 30, '正式場合必備', '2023-10-17 15:50:00', '2023-10-18 15:50:00'),
    ('碎花雪紡洋裝', 'CLOTHING', 'https://example.com/img/dress.jpg', 1100, 65, '約會度假風格', '2023-10-18 16:30:00', '2023-10-19 16:30:00'),
    ('兒童純棉睡衣', 'CLOTHING', 'https://example.com/img/kids_pajamas.jpg', 690, 80, '安心無毒材質', '2023-10-19 17:20:00', '2023-10-20 17:20:00'),
    ('機能防潑水短褲', 'CLOTHING', 'https://example.com/img/shorts.jpg', 890, 130, '戶外活動首選短褲', '2023-10-20 18:10:00', '2023-10-21 18:10:00'),

-- [ 圖書與文具 ]
    ('原子習慣', 'BOOKS', 'https://example.com/img/atomic_habits.jpg', 330, 150, '細微改變帶來巨大成就的實證法則', '2023-11-01 08:00:00', '2023-11-02 08:00:00'),
    ('被討厭的勇氣', 'BOOKS', 'https://example.com/img/courage.jpg', 300, 120, '自我啟發之父阿德勒的教導', '2023-11-02 09:10:00', '2023-11-03 09:10:00'),
    ('刻意練習', 'BOOKS', 'https://example.com/img/deliberate.jpg', 320, 90, '原創者全面解析，比天賦更關鍵的學習法', '2023-11-03 10:20:00', '2023-11-04 10:20:00'),
    ('窮爸爸富爸爸', 'BOOKS', 'https://example.com/img/richdad.jpg', 350, 200, '理財入門經典必讀', '2023-11-04 11:30:00', '2023-11-05 11:30:00'),
    ('投資最重要的事', 'BOOKS', 'https://example.com/img/investment.jpg', 380, 85, '一本股神巴菲特讀了兩遍的書', '2023-11-05 12:40:00', '2023-11-06 12:40:00'),
    ('Python自動化輕鬆學', 'BOOKS', 'https://example.com/img/python.jpg', 550, 60, '給初學者的程式設計指南', '2023-11-06 13:50:00', '2023-11-07 13:50:00'),
    ('哈利波特：神祕的魔法石', 'BOOKS', 'https://example.com/img/hp1.jpg', 450, 110, '奇幻文學經典大作', '2023-11-07 14:15:00', '2023-11-08 14:15:00'),
    ('百年孤寂', 'BOOKS', 'https://example.com/img/solitude.jpg', 420, 45, '魔幻寫實主義代表作', '2023-11-08 15:25:00', '2023-11-09 15:25:00'),
    ('設計的心理學', 'BOOKS', 'https://example.com/img/design.jpg', 480, 75, 'UI/UX 設計師必讀經典', '2023-11-09 16:35:00', '2023-11-10 16:35:00'),
    ('人類大歷史', 'BOOKS', 'https://example.com/img/sapiens.jpg', 550, 130, '從野獸到扮演上帝', '2023-11-10 17:45:00', '2023-11-11 17:45:00'),
    ('MUJI 凝膠墨水筆(黑)', 'STATIONERY', 'https://example.com/img/muji_pen.jpg', 30, 500, '書寫滑順的按壓原子筆', '2023-11-11 08:30:00', '2023-11-12 08:30:00'),
    ('A5 網點筆記本', 'STATIONERY', 'https://example.com/img/notebook.jpg', 120, 250, '適合子彈筆記的無酸紙', '2023-11-12 09:40:00', '2023-11-13 09:40:00'),
    ('Pentel 飛龍橡皮擦', 'STATIONERY', 'https://example.com/img/eraser.jpg', 15, 600, '從小用到大的神級橡皮擦', '2023-11-13 10:50:00', '2023-11-14 10:50:00'),
    ('3M 狠黏便條紙', 'STATIONERY', 'https://example.com/img/postit.jpg', 65, 350, '辦公室必備便條紙', '2023-11-14 11:10:00', '2023-11-15 11:10:00'),
    ('KOKUYO 無針釘書機', 'STATIONERY', 'https://example.com/img/stapler.jpg', 250, 100, '環保安全無針設計', '2023-11-15 12:20:00', '2023-11-16 12:20:00'),
    ('雙面膠帶(5入)', 'STATIONERY', 'https://example.com/img/tape.jpg', 100, 200, '強黏好撕雙面膠', '2023-11-16 13:30:00', '2023-11-17 13:30:00'),
    ('PLUS 修正帶', 'STATIONERY', 'https://example.com/img/correction.jpg', 45, 400, '順暢不斷帶立可帶', '2023-11-17 14:40:00', '2023-11-18 14:40:00'),
    ('不鏽鋼美工刀', 'STATIONERY', 'https://example.com/img/cutter.jpg', 80, 150, '銳利耐用的防鏽美工刀', '2023-11-18 15:50:00', '2023-11-19 15:50:00'),
    ('高質感皮質筆袋', 'STATIONERY', 'https://example.com/img/pencilcase.jpg', 390, 80, '簡約設計大容量筆袋', '2023-11-19 16:15:00', '2023-11-20 16:15:00'),
    ('多功能金屬文件夾', 'STATIONERY', 'https://example.com/img/clip.jpg', 150, 180, '辦公收納好幫手', '2023-11-20 17:25:00', '2023-11-21 17:25:00'),

-- [ 居家與生活 ]
    ('無印風雙人床包', 'HOME', 'https://example.com/img/bedsheet.jpg', 1280, 70, '100%天絲柔滑觸感', '2023-12-01 09:00:00', '2023-12-02 09:00:00'),
    ('記憶矽膠枕', 'HOME', 'https://example.com/img/pillow.jpg', 890, 100, '人體工學護頸設計', '2023-12-02 10:00:00', '2023-12-03 10:00:00'),
    ('日系極簡馬克杯', 'HOME', 'https://example.com/img/mug.jpg', 250, 200, '陶瓷啞光質感水杯', '2023-12-03 11:15:00', '2023-12-04 11:15:00'),
    ('珪藻土吸水地墊', 'HOME', 'https://example.com/img/mat.jpg', 399, 150, '速乾防滑浴室地墊', '2023-12-04 12:30:00', '2023-12-05 12:30:00'),
    ('智能感應垃圾桶', 'HOME', 'https://example.com/img/trashcan.jpg', 1200, 60, '紅外線自動開蓋設計', '2023-12-05 13:45:00', '2023-12-06 13:45:00'),
    ('北歐風實木餐椅', 'HOME', 'https://example.com/img/chair.jpg', 1580, 40, '簡約百搭實木椅', '2023-12-06 14:00:00', '2023-12-07 14:00:00'),
    ('LED 護眼檯燈', 'HOME', 'https://example.com/img/lamp.jpg', 850, 90, '無頻閃多段調光檯燈', '2023-12-07 15:10:00', '2023-12-08 15:10:00'),
    ('香氛融蠟燈', 'HOME', 'https://example.com/img/wax_lamp.jpg', 1100, 50, '無火香氛安全首選', '2023-12-08 16:20:00', '2023-12-09 16:20:00'),
    ('玻璃保鮮盒(3件組)', 'HOME', 'https://example.com/img/box.jpg', 599, 120, '耐熱玻璃可微波', '2023-12-09 17:30:00', '2023-12-10 17:30:00'),
    ('不沾平底鍋 28cm', 'HOME', 'https://example.com/img/pan.jpg', 1450, 80, '韓國進口麥飯石不沾鍋', '2023-12-10 18:40:00', '2023-12-11 18:40:00'),
    ('手沖咖啡壺組', 'HOME', 'https://example.com/img/coffee.jpg', 1800, 45, '包含濾杯、手沖壺與分享壺', '2023-12-11 09:50:00', '2023-12-12 09:50:00'),
    ('木質面紙盒', 'HOME', 'https://example.com/img/tissuebox.jpg', 350, 160, '質感原木面紙收納盒', '2023-12-12 10:20:00', '2023-12-13 10:20:00'),
    ('防潑水沙發套', 'HOME', 'https://example.com/img/sofacover.jpg', 990, 70, '高彈力全包沙發保護套', '2023-12-13 11:10:00', '2023-12-14 11:10:00'),
    ('多層鞋架', 'HOME', 'https://example.com/img/shoerack.jpg', 650, 95, '省空間簡易組裝鞋架', '2023-12-14 12:45:00', '2023-12-15 12:45:00'),
    ('衣物真空壓縮袋(10入)', 'HOME', 'https://example.com/img/vacuum.jpg', 499, 200, '換季收納神器', '2023-12-15 13:30:00', '2023-12-16 13:30:00'),
    ('日式陶瓷碗(4入)', 'HOME', 'https://example.com/img/bowl.jpg', 550, 110, '高溫燒製手工彩繪', '2023-12-16 14:15:00', '2023-12-17 14:15:00'),
    ('不鏽鋼保溫瓶 500ml', 'HOME', 'https://example.com/img/thermos.jpg', 790, 140, '長效保溫保冷水壺', '2023-12-17 15:00:00', '2023-12-18 15:00:00'),
    ('無框畫裝飾', 'HOME', 'https://example.com/img/painting.jpg', 1200, 55, '北歐幾何客廳掛畫', '2023-12-18 16:20:00', '2023-12-19 16:20:00'),
    ('掃地機器人', 'HOME', 'https://example.com/img/robot.jpg', 8900, 25, '自動回充智能掃拖一體機', '2023-12-19 17:35:00', '2023-12-20 17:35:00'),
    ('負離子空氣清淨機', 'HOME', 'https://example.com/img/air.jpg', 4500, 40, '去除異味與PM2.5', '2023-12-20 18:45:00', '2023-12-21 18:45:00'),

-- [ 食品與保健 ]
    ('高蛋白乳清(巧克力口味)', 'FOOD', 'https://example.com/img/whey.jpg', 1250, 200, '健身族群必備高蛋白粉', '2024-01-01 08:30:00', '2024-01-02 08:30:00'),
    ('綜合堅果量販包', 'FOOD', 'https://example.com/img/nuts.jpg', 450, 300, '無調味低溫烘焙健康堅果', '2024-01-02 09:15:00', '2024-01-03 09:15:00'),
    ('滴雞精禮盒(10入)', 'FOOD', 'https://example.com/img/chicken_essence.jpg', 1580, 80, '古法熬製滋補養生', '2024-01-03 10:20:00', '2024-01-04 10:20:00'),
    ('高濃度魚油', 'FOOD', 'https://example.com/img/fishoil.jpg', 990, 150, 'Omega-3 EPA/DHA 營養補充', '2024-01-04 11:40:00', '2024-01-05 11:40:00'),
    ('葉黃素軟膠囊', 'FOOD', 'https://example.com/img/lutein.jpg', 850, 180, '3C重度使用者晶亮配方', '2024-01-05 12:10:00', '2024-01-06 12:10:00'),
    ('燕麥奶 1L (6罐入)', 'FOOD', 'https://example.com/img/oatmilk.jpg', 990, 120, '無糖咖啡師專用燕麥奶', '2024-01-06 13:50:00', '2024-01-07 13:50:00'),
    ('花蓮富里米 5kg', 'FOOD', 'https://example.com/img/rice.jpg', 420, 90, '履歷認證台灣好米', '2024-01-07 14:00:00', '2024-01-08 14:00:00'),
    ('掛耳式咖啡(30包)', 'FOOD', 'https://example.com/img/dripcoffee.jpg', 600, 250, '阿拉比卡中深焙', '2024-01-08 15:30:00', '2024-01-09 15:30:00'),
    ('英式伯爵茶包', 'FOOD', 'https://example.com/img/tea.jpg', 350, 300, '百年茶莊經典風味', '2024-01-09 16:45:00', '2024-01-10 16:45:00'),
    ('紐西蘭進口蜂蜜', 'FOOD', 'https://example.com/img/honey.jpg', 750, 70, '純天然麥蘆卡蜂蜜', '2024-01-10 17:15:00', '2024-01-11 17:15:00'),
    ('低卡蒟蒻麵(6包)', 'FOOD', 'https://example.com/img/noodles.jpg', 299, 140, '熱量控制宵夜良伴', '2024-01-11 08:50:00', '2024-01-12 08:50:00'),
    ('黑巧克力 85%', 'FOOD', 'https://example.com/img/chocolate.jpg', 180, 400, '濃郁滑順低糖巧克力', '2024-01-12 09:25:00', '2024-01-13 09:25:00'),
    ('天然海鹽', 'FOOD', 'https://example.com/img/salt.jpg', 120, 200, '無碘天然粗鹽', '2024-01-13 10:10:00', '2024-01-14 10:10:00'),
    ('冷壓初榨橄欖油', 'FOOD', 'https://example.com/img/oliveoil.jpg', 680, 85, '義大利原裝進口', '2024-01-14 11:30:00', '2024-01-15 11:30:00'),
    ('無添加蔓越莓乾', 'FOOD', 'https://example.com/img/cranberry.jpg', 250, 160, '保留完整果實營養', '2024-01-15 12:45:00', '2024-01-16 12:45:00'),
    ('有機紅藜麥', 'FOOD', 'https://example.com/img/quinoa.jpg', 320, 110, '超級食物營養滿分', '2024-01-16 13:20:00', '2024-01-17 13:20:00'),
    ('綜合益生菌(30包)', 'FOOD', 'https://example.com/img/probiotics.jpg', 1200, 130, '維持消化道機能', '2024-01-17 14:15:00', '2024-01-18 14:15:00'),
    ('高山烏龍茶葉', 'FOOD', 'https://example.com/img/oolong.jpg', 800, 60, '手採一心二葉', '2024-01-18 15:50:00', '2024-01-19 15:50:00'),
    ('黑糖薑茶磚', 'FOOD', 'https://example.com/img/ginger.jpg', 200, 220, '手作古法暖身熱飲', '2024-01-19 16:30:00', '2024-01-20 16:30:00'),
    ('進口礦泉水 1.5L(12瓶)', 'FOOD', 'https://example.com/img/water.jpg', 550, 80, '富含天然礦物質', '2024-01-20 17:10:00', '2024-01-21 17:10:00'),

-- [ 運動與戶外 ]
    ('迪卡儂 20L 登山包', 'OUTDOOR', 'https://example.com/img/hike_bag.jpg', 499, 100, '輕量耐磨防潑水', '2024-02-01 09:00:00', '2024-02-02 09:00:00'),
    ('露營折疊椅', 'OUTDOOR', 'https://example.com/img/camp_chair.jpg', 650, 120, '鋁合金輕量月亮椅', '2024-02-02 10:15:00', '2024-02-03 10:15:00'),
    ('四人自動快速帳篷', 'OUTDOOR', 'https://example.com/img/tent.jpg', 3500, 40, '三秒快開防雨露營帳篷', '2024-02-03 11:20:00', '2024-02-04 11:20:00'),
    ('瑜珈墊 8mm', 'OUTDOOR', 'https://example.com/img/yogamat.jpg', 599, 150, 'TPE環保材質防滑加厚', '2024-02-04 12:40:00', '2024-02-05 12:40:00'),
    ('可調式啞鈴 24kg', 'OUTDOOR', 'https://example.com/img/dumbbell.jpg', 3200, 30, '一秒切換重量居家健身', '2024-02-05 13:50:00', '2024-02-06 13:50:00'),
    ('筋膜按摩槍', 'OUTDOOR', 'https://example.com/img/massage_gun.jpg', 1580, 80, '深層放鬆運動後肌肉', '2024-02-06 14:10:00', '2024-02-07 14:10:00'),
    ('羽毛球拍(雙拍組)', 'OUTDOOR', 'https://example.com/img/badminton.jpg', 890, 110, '碳纖維超輕羽球拍', '2024-02-07 15:30:00', '2024-02-08 15:30:00'),
    ('室內籃球 7號', 'OUTDOOR', 'https://example.com/img/basketball.jpg', 750, 90, '耐磨PU材質', '2024-02-08 16:45:00', '2024-02-09 16:45:00'),
    ('游泳蛙鏡', 'OUTDOOR', 'https://example.com/img/goggles.jpg', 350, 200, '高清防霧電鍍鏡片', '2024-02-09 17:15:00', '2024-02-10 17:15:00'),
    ('腳踏車安全帽', 'OUTDOOR', 'https://example.com/img/helmet.jpg', 1200, 60, '流線型透氣自行車帽', '2024-02-10 18:20:00', '2024-02-11 18:20:00'),
    ('睡袋', 'OUTDOOR', 'https://example.com/img/sleepingbag.jpg', 1800, 50, '極限溫度-5度保暖睡袋', '2024-02-11 09:30:00', '2024-02-12 09:30:00'),
    ('保冷箱 30L', 'OUTDOOR', 'https://example.com/img/cooler.jpg', 1650, 45, '露營烤肉保鮮必備', '2024-02-12 10:45:00', '2024-02-13 10:45:00'),
    ('LED 露營燈', 'OUTDOOR', 'https://example.com/img/camplamp.jpg', 550, 130, '可充電復古營地燈', '2024-02-13 11:10:00', '2024-02-14 11:10:00'),
    ('運動水壺 1000ml', 'OUTDOOR', 'https://example.com/img/bottle.jpg', 450, 180, 'Tritan材質防漏水壺', '2024-02-14 12:20:00', '2024-02-15 12:20:00'),
    ('彈力帶套組(5條入)', 'OUTDOOR', 'https://example.com/img/bands.jpg', 299, 250, '阻力訓練多功能拉力帶', '2024-02-15 13:50:00', '2024-02-16 13:50:00'),
    ('戶外防曬袖套', 'OUTDOOR', 'https://example.com/img/sleeves.jpg', 150, 300, '冰絲涼感抗UV', '2024-02-16 14:15:00', '2024-02-17 14:15:00'),
    ('智慧跳繩', 'OUTDOOR', 'https://example.com/img/jumprope.jpg', 699, 85, '藍牙連接紀錄次數', '2024-02-17 15:40:00', '2024-02-18 15:40:00'),
    ('登山杖', 'OUTDOOR', 'https://example.com/img/pole.jpg', 850, 70, '碳纖維避震摺疊手杖', '2024-02-18 16:25:00', '2024-02-19 16:25:00'),
    ('防水野餐墊', 'OUTDOOR', 'https://example.com/img/picnicmat.jpg', 450, 110, '加厚防潮可機洗', '2024-02-19 17:10:00', '2024-02-20 17:10:00'),
    ('單車車頭燈', 'OUTDOOR', 'https://example.com/img/bikelight.jpg', 390, 140, 'USB充電高亮度強光燈', '2024-02-20 18:30:00', '2024-02-21 18:30:00')