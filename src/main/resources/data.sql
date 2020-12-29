create table if not exists persistent_logins (
     username varchar(100) not null,
     series varchar(64) primary key,
     token varchar(64) not null,
     last_used timestamp not null
);

delete from  user_role;
delete from  roles;
delete from  users;
delete from  news;


INSERT INTO roles ( name) VALUES
('ROLE_ADMIN'),
('ROLE_KOMISYONCU'),
('ROLE_USER');

INSERT INTO users (email, password, firstname ,lastname) VALUES
('faruksengoz@denizhal.com', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Faruk' ,'Şengöz'),
('seydaozdemir@denizhal.com', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'Seyda' ,'Özdemir'),
('appdownload@denizhal.com', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'App' ,'Download');;



insert into user_role(user_id, role_id) values
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(2,3),
(3,3);

INSERT INTO news(title,details,foto_url,savedate,ziyaret,user_id) VALUES
('Hal Kayıt Sistemi Künye Bildirimi','Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', '\\src\\main\\uploads\\logo6.png',DATE('2020-12-20'),0,1),
('E-Fatura Yenilikleri','Lorem Ipsum dsfm ldfk sdlkf jdslf sdfkl jsdlfj ljsd flsjd flwej fılewj flefj lwfj sdl fsdlf nl dnaskdnas klsdkj fndskjf nsdk fndskf nsdkf ndskfj dkfn asdknsdkjfkjd kdsjf nsdkjf nsdkjjf nksdfn akjsd nsdkjf nkdsj fdskjfn ', '\\src\\main\\uploads\\logo3.png',DATE('2020-12-22'),2,1);

INSERT INTO products(name,version,savedate,demo_link,app_link) VALUES
('Deniz Hal Otomasyon Programı', '1.0' ,DATE('2020-12-22') ,'\\src\\main\\uploads\\demo\\demo.jpg','\\src\\main\\uploads\\app\\app.jpg');

INSERT INTO proposes(sirket_adi,ad_soyad,tel,email,il,ilce,savedate,product_id) VALUES
('Hal No 45','Hasan Yılmaz','05555555555','hasan@gmail.com','Antalya','Merkez',DATE('2020-12-22'),1),
('Hal No 90','Kasan Yılmaz','05325323232','hasan@gmail.com','Antalya','Serik',DATE('2020-12-23'),1),
('Hal No 137','Taşan Yılmaz','02425724000','hasan@gmail.com','Antalya','Gazipaşa',DATE('2020-12-12'),1);

INSERT INTO kurumsal(title,details,foto_url_1,title2,details2,foto_url_2,title3,details3,foto_url_3,savedate) VALUES
('Kurumsal','Deniz Bilgisayar bilişim sektöründe 1998\'den beri faaliyet göstermektedir.','\\src\\main\\uploads\\logo3.png','Hal Kayıt Sistemi','Sunduğumuz çözümlerle Ticaret Bakanlığı Hal Kayıt Sistemine uygun, Ad vitae recusandae odit possimus. Quaerat cum ipsum corrupti. Odit qui asperiores ea corporis deserunt veritatis quidem expedita perferendis. Qui rerum eligendi ex doloribus quia sit. Porro rerum eum eum.','\\src\\main\\uploads\\logo6.png','E-İşlemler' ,'e-Fatura, e-Arşiv , e-Müstahsil, e-Defter, e-Makbuz işlemlerini hızlı ve güvenli gerçekleştirmenizi sağlar.','\\src\\main\\uploads\\logo5.png',  DATE('2020-12-20'));

