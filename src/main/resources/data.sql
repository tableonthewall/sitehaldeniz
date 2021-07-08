create table if not exists persistent_logins (
     username varchar(100) not null,
     series varchar(64) primary key,
     token varchar(64) not null,
     last_used timestamp not null
);





INSERT INTO roles ( name) VALUES
('ROLE_ADMIN'),
('ROLE_KOMISYONCU'),
('ROLE_USER');

INSERT INTO users (email, password, firstname ,lastname) VALUES
('faruksengoz@denizhal.com', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Faruk' ,'Şengöz'),
('seydaozdemir@denizhal.com', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'Seyda' ,'Özdemir'),
('appdownload@denizhal.com', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'App' ,'Download');



insert into user_role(user_id, role_id) values
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(2,3),
(3,3);

INSERT INTO news(title,details,foto_url,savedate,ziyaret,user_id) VALUES
('Hal Kayıt Sistemi Künye Bildirimi','Künye bildirim işlemlerinizi hızlı bir şekilde, Hal Kayıt Sistemi(HKS) ile uyumlu olarak gerçekleştirebilirsiniz.', '/src/main/uploads/logo4.png',DATE('2020-12-20'),0,1),
('E-Fatura Yenilikleri','E-fatura yönetimi hiç bu kadar kolay olmamıştı. Değişen teknoloji ile birlikte şirketler fatura işlemlerini bilişim teknolojileri ve internet aracılığı ile kolaylıkla gerçekleştirebilirler. ', '/src/main/uploads/logo5.png',DATE('2020-12-22'),2,1);

INSERT INTO products(name,version,savedate,demo_link,app_link) VALUES
('Deniz Hal Otomasyon Programı', '1.0' ,DATE('2020-12-22') ,'http://www.asesyazilim.com/update/halsetup/DenizHalSetup.exe','http://www.asesyazilim.com/update/halsetup/DenizHalSetup.exe');

INSERT INTO proposes(sirket_adi,ad_soyad,tel,email,il,ilce,savedate,product_id) VALUES
('Hal No 45','Hasan Yılmaz','05555555555','hasan@gmail.com','Antalya','Merkez',DATE('2020-12-22'),1),
('Hal No 90','Kasan Yılmaz','05325323232','hasan@gmail.com','Antalya','Serik',DATE('2020-12-23'),1),
('Hal No 137','Taşan Yılmaz','02425724000','hasan@gmail.com','Antalya','Gazipaşa',DATE('2020-12-12'),1);

INSERT INTO kurumsal(title,details,foto_url_1,title2,details2,foto_url_2,title3,details3,foto_url_3,savedate) VALUES
('Kurumsal','Deniz Bilgisayar bilişim sektöründe 1998\'den beri faaliyet göstermektedir.','/src/main/uploads/logo3v2.png','Hal Kayıt Sistemi','Sunduğumuz çözümlerle Ticaret Bakanlığı Hal Kayıt Sistemine uygun, hızlı, güvenli künye bildirimi gerçekleştirilir.','/src/main/uploads/logo4v2.png','E-İşlemler' ,'e-Fatura, e-Arşiv , e-Müstahsil, e-Defter, e-Makbuz işlemlerini hızlı ve güvenli gerçekleştirmenizi sağlar.','/src/main/uploads/logo5v2.png',  DATE('2020-12-20'));

