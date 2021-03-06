/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/9 8:36:29                             */
/*==============================================================*/


drop table if exists Administrator_information_table;

drop table if exists Bill_collection_and_voucher_delivery_form;

drop table if exists Business_information_table;

drop table if exists Commodity_category_table;

drop table if exists Commodity_evaluation_form;

drop table if exists Commodity_list;

drop table if exists Commodity_order;

drop table if exists Coupon_holding_form;

drop table if exists Coupon_information_sheet;

drop table if exists Delivery_address_list;

drop table if exists Full_reduction_scheme_table;

drop table if exists Order_details;

drop table if exists Rider_entry;

drop table if exists Rider_information_sheet;

drop table if exists User_information_table;

/*==============================================================*/
/* Table: Administrator_information_table                       */
/*==============================================================*/
create table Administrator_information_table
(
   Employee_ID          varchar(20) not null,
   Employee_Name        varchar(20),
   Login_password       varchar(20),
   primary key (Employee_ID)
);

/*==============================================================*/
/* Table: Bill_collection_and_voucher_delivery_form             */
/*==============================================================*/
create table Bill_collection_and_voucher_delivery_form
(
   Business_ID          varchar(20) not null,
   Coupon_ID            varchar(20) not null,
   User_ID              varchar(20) not null,
   Required_number_of_orders varchar(20),
   Number_of_orders     varchar(20),
   primary key (Business_ID, Coupon_ID, User_ID)
);

/*==============================================================*/
/* Table: Business_information_table                            */
/*==============================================================*/
create table Business_information_table
(
   Business_ID          varchar(20) not null,
   Business_Name        varchar(20),
   Business_star        varchar(20),
   Per_capita_consumption varchar(20),
   Total_sales          varchar(20),
   primary key (Business_ID)
);

/*==============================================================*/
/* Table: Commodity_category_table                              */
/*==============================================================*/
create table Commodity_category_table
(
   Classification_number varchar(20) not null,
   Commodity_ID         varchar(20),
   Business_ID          varchar(20),
   Category_column_name varchar(20),
   Quantity_of_goods    varchar(20),
   primary key (Classification_number)
);

/*==============================================================*/
/* Table: Commodity_evaluation_form                             */
/*==============================================================*/
create table Commodity_evaluation_form
(
   User_ID              varchar(20) not null,
   Commodity_ID         varchar(20) not null,
   Business_ID          varchar(20) not null,
   Evaluation_content   varchar(20),
   Evaluation_date      datetime,
   Star_rating          varchar(20),
   Photo                varchar(20),
   primary key (User_ID, Commodity_ID, Business_ID)
);

/*==============================================================*/
/* Table: Commodity_list                                        */
/*==============================================================*/
create table Commodity_list
(
   Commodity_ID         varchar(20) not null,
   Category_number      varchar(20),
   Commodity_Name       varchar(20),
   Price                varchar(20),
   primary key (Commodity_ID)
);

/*==============================================================*/
/* Table: Commodity_order                                       */
/*==============================================================*/
create table Commodity_order
(
   Business_ID          varchar(20) not null,
   Commodity_ID         varchar(20) not null,
   User_ID              varchar(20) not null,
   Rider_ID             varchar(20) not null,
   Coupon_ID            varchar(20) not null,
   Full_minus_ID        varchar(20) not null,
   Original_amount      varchar(20),
   Settlement_amount    varchar(20),
   Order_time           datetime,
   Time_of_service_required datetime,
   Address_number       varchar(20),
   Order_status         varchar(20),
   primary key (Business_ID, Commodity_ID, User_ID, Rider_ID, Coupon_ID, Full_minus_ID)
);

/*==============================================================*/
/* Table: Coupon_holding_form                                   */
/*==============================================================*/
create table Coupon_holding_form
(
   User_ID              varchar(20) not null,
   Business_ID          varchar(20) not null,
   Preferential_amount  varchar(20),
   Number               varchar(20),
   closing_date         datetime,
   primary key (User_ID, Business_ID)
);

/*==============================================================*/
/* Table: Coupon_information_sheet                              */
/*==============================================================*/
create table Coupon_information_sheet
(
   Coupon_ID            varchar(20) not null,
   Preferential_amount  varchar(20),
   Required_number_of_orders varchar(20),
   Start_date           datetime,
   End_date             datetime,
   primary key (Coupon_ID)
);

/*==============================================================*/
/* Table: Delivery_address_list                                 */
/*==============================================================*/
create table Delivery_address_list
(
   Address_number       varchar(20) not null,
   User_ID              varchar(20),
   province             varchar(20),
   city                 varchar(20),
   area                 varchar(20),
   address              varchar(20),
   contacts             varchar(20),
   phone_number         varchar(20),
   primary key (Address_number)
);

/*==============================================================*/
/* Table: Full_reduction_scheme_table                           */
/*==============================================================*/
create table Full_reduction_scheme_table
(
   Full_minus_ID        varchar(20) not null,
   Full_reduction_amount varchar(20),
   Preferential_amount  varchar(20),
   Can_it_be_superimposed_with_coupons bool,
   primary key (Full_minus_ID)
);

/*==============================================================*/
/* Table: Order_details                                         */
/*==============================================================*/
create table Order_details
(
   Order_ID             varchar(20) not null,
   Commodity_ID         varchar(20),
   Number               varchar(20),
   Price                varchar(20),
   Discount_amount_of_single_product varchar(20),
   primary key (Order_ID)
);

/*==============================================================*/
/* Table: Rider_entry                                           */
/*==============================================================*/
create table Rider_entry
(
   Rider_ID             varchar(20) not null,
   User_ID              varchar(20) not null,
   Order_ID             varchar(20) not null,
   time                 datetime,
   User_evaluation      varchar(20) not null,
   Single_income        varchar(20),
   primary key (Rider_ID, User_ID, Order_ID)
);

/*==============================================================*/
/* Table: Rider_information_sheet                               */
/*==============================================================*/
create table Rider_information_sheet
(
   Rider_ID             varchar(20) not null,
   Rider_Name           varchar(20),
   Entry_date           datetime,
   Rider_status         varchar(20),
   primary key (Rider_ID)
);

/*==============================================================*/
/* Table: User_information_table                                */
/*==============================================================*/
create table User_information_table
(
   User_ID              varchar(20) not null,
   Del_Address_number   varchar(20),
   User_Name            varchar(10),
   User_Gender          varchar(10),
   User_Password        varchar(20),
   User_PhoneNumber     varchar(20),
   User_email           varchar(20),
   Address_number       varchar(20),
   User_Registration_time datetime,
   Is_it_a_member       bool,
   Membership_deadline  datetime,
   primary key (User_ID)
);

alter table Bill_collection_and_voucher_delivery_form add constraint FK_Bill_collection_and_voucher_delivery_form foreign key (Business_ID)
      references Business_information_table (Business_ID) on delete restrict on update restrict;

alter table Bill_collection_and_voucher_delivery_form add constraint FK_Bill_collection_and_voucher_delivery_form foreign key (Coupon_ID)
      references Coupon_information_sheet (Coupon_ID) on delete restrict on update restrict;

alter table Bill_collection_and_voucher_delivery_form add constraint FK_Bill_collection_and_voucher_delivery_form foreign key (User_ID)
      references User_information_table (User_ID) on delete restrict on update restrict;

alter table Commodity_category_table add constraint FK_Relationship_1 foreign key (Commodity_ID)
      references Commodity_list (Commodity_ID) on delete restrict on update restrict;

alter table Commodity_category_table add constraint FK_Relationship_3 foreign key (Business_ID)
      references Business_information_table (Business_ID) on delete restrict on update restrict;

alter table Commodity_evaluation_form add constraint FK_Commodity_evaluation_form foreign key (Business_ID)
      references Business_information_table (Business_ID) on delete restrict on update restrict;

alter table Commodity_evaluation_form add constraint FK_Commodity_evaluation_form foreign key (Commodity_ID)
      references Commodity_list (Commodity_ID) on delete restrict on update restrict;

alter table Commodity_evaluation_form add constraint FK_Commodity_evaluation_form foreign key (User_ID)
      references User_information_table (User_ID) on delete restrict on update restrict;

alter table Commodity_evaluation_form add constraint FK_Commodity_evaluation_form2 foreign key (Business_ID)
      references Business_information_table (Business_ID) on delete restrict on update restrict;

alter table Commodity_order add constraint FK_Commodity_order foreign key (Business_ID)
      references Business_information_table (Business_ID) on delete restrict on update restrict;

alter table Commodity_order add constraint FK_Commodity_order foreign key (Commodity_ID)
      references Commodity_list (Commodity_ID) on delete restrict on update restrict;

alter table Commodity_order add constraint FK_Commodity_order foreign key (Coupon_ID)
      references Coupon_information_sheet (Coupon_ID) on delete restrict on update restrict;

alter table Commodity_order add constraint FK_Commodity_order foreign key (Address_number)
      references Delivery_address_list (Address_number) on delete restrict on update restrict;

alter table Commodity_order add constraint FK_Commodity_order foreign key (Full_minus_ID)
      references Full_reduction_scheme_table (Full_minus_ID) on delete restrict on update restrict;

alter table Commodity_order add constraint FK_Commodity_order foreign key (Rider_ID)
      references Rider_information_sheet (Rider_ID) on delete restrict on update restrict;

alter table Commodity_order add constraint FK_Commodity_order foreign key (User_ID)
      references User_information_table (User_ID) on delete restrict on update restrict;

alter table Commodity_order add constraint FK_Commodity_order2 foreign key (Coupon_ID)
      references Coupon_information_sheet (Coupon_ID) on delete restrict on update restrict;

alter table Commodity_order add constraint FK_Commodity_order2 foreign key (Full_minus_ID)
      references Full_reduction_scheme_table (Full_minus_ID) on delete restrict on update restrict;

alter table Coupon_holding_form add constraint FK_Coupon_holding_form foreign key (Business_ID)
      references Business_information_table (Business_ID) on delete restrict on update restrict;

alter table Coupon_holding_form add constraint FK_Coupon_holding_form foreign key (User_ID)
      references User_information_table (User_ID) on delete restrict on update restrict;

alter table Rider_entry add constraint FK_Rider_entry foreign key (Order_ID)
      references Order_details (Order_ID) on delete restrict on update restrict;

alter table Rider_entry add constraint FK_Rider_entry foreign key (Rider_ID)
      references Rider_information_sheet (Rider_ID) on delete restrict on update restrict;

alter table Rider_entry add constraint FK_Rider_entry foreign key (User_ID)
      references User_information_table (User_ID) on delete restrict on update restrict;

alter table User_information_table add constraint FK_Relationship_2 foreign key (Del_Address_number)
      references Delivery_address_list (Address_number) on delete restrict on update restrict;

