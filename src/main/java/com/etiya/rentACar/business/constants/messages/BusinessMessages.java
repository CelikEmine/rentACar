package com.etiya.rentACar.business.constants.messages;

public class BusinessMessages {
    public class MaintenanceMessages{
        public static final String MAINTENANCE_ADDED="Başarıyla Eklendi.";
        public static final String MAINTENANCE_DELETED="Başarıyla Silindi.";
        public static final String MAINTENANCE_UPDATED="Başarıyla Güncellendi.";
    }

    public class BrandMessages{
        public static final String BRAND_ADDED="Başarıyla Eklendi.";
        public static final String BRAND_DELETED="Başarıyla Silindi.";
        public static final String BRAND_UPDATED="Başarıyla Güncellendi.";
        public static final String EXISTED_BEFORE = "bu marka daha önce kaydedilmiştir";
    }

    public class CarMessages{
        public static final String CAR_ADDED="Başarıyla Eklendi.";
        public static final String CAR_DELETED="Başarıyla Silindi.";
        public static final String CAR_UPDATED="Başarıyla Güncellendi.";
        public static final String CAR_LISTED = "Veriler Başarıyla Listelendi";
        public static final String CAR_UNDERMAINTANANCE="Bu Araç bakımda";
        public static final String CAR_RENTED="Bu Araç kirada";
        public static final String NOT_EXIST_BEFORE ="bu kayıtta bir araç yok" ;
    }

    public class ColorMessages{
        public static final String COLOR_ADDED="Başarıyla Eklendi.";
        public static final String COLOR_DELETED="Başarıyla Silindi.";
        public static final String COLOR_UPDATED="Başarıyla Güncellendi.";
        public static final String COLOR_REGISTERED = "bu renk daha önce kaydedilmiştir";
    }

    public class DamageMessages{
        public static final String DAMAGE_ADDED="Başarıyla Eklendi.";
        public static final String DAMAGE_DELETED="Başarıyla Silindi.";
        public static final String DAMAGE_UPDATED="Başarıyla Güncellendi.";
    }

    public class RentalMessages{
        public static final String RENTAL_ADDED="Kiralama İşlemi Başarılı";
        public static final String RENTAL_DELETED="Başarıyla Silindi.";
        public static final String RENTAL_UPDATED="Başarıyla Güncellendi.";
    }

    public class CustomerMessages{
        public static final String CUSTOMER_ADDED="Başarıylda eklendi";
        public static final String CUSTOMER_DELETED="Başarıyla Silindi.";
        public static final String CUSTOMER_UPDATED="Başarıyla Güncellendi.";
        public static final String CUSTOMER_REGISTERED_NATIONALITYID ="Bu tc ile daha önceden kayıt bulunmaktadır" ;
    }

    public class CityMessages{
        public static final String CİTY_ADDED="Başarıylda eklendi";
        public static final String CİTY_DELETED="Başarıyla Silindi.";
        public static final String CİTY_UPDATED="Başarıyla Güncellendi.";
        public static final String CİTY_REGISTERED_NAME ="Bu isim ile daha önceden kayıt bulunmaktadır" ;

    }

    public class AdditionalServiceMessages{
        public static final String ADDITIONAL_SERVİCE_ADDED="Başarıylda eklendi";
        public static final String ADDITIONAL_SERVİCE_DELETED="Başarıyla Silindi.";
        public static final String ADDITIONAL_SERVİCE_UPDATED="Başarıyla Güncellendi.";
        public static final String  ADDITIONAL_SERVİCE_REGISTERED_NAME ="Bu isim ile daha önceden kayıt bulunmaktadır" ;

    }

    public class InvoiceMessages{
        public static final String INVOICE_ADDED="Başarıylda eklendi";
        public static final String INVOICE_DELETED="Başarıyla Silindi.";
        public static final String INVOICE_UPDATED="Başarıyla Güncellendi.";

    }

    public class PaymentMessage {
        public static final String PAYMENT = " !";
        public static final String PAYMENT_ADDED="ÖDEME EKLENDİ";
        public static final String PAYMENT_UPDATED="ÖDEME GÜNCELLENDİ";
        public static final String PAYMENT_DELETED="ÖDEME SİLİNDİ";
        public static final String PAYMENT_NOT_ACCEPTED ="ÖDEME KABUL EDİLMEDİ";

    }



}
