package com.example.spleshanimataiontest.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderModel implements Serializable {

    @SerializedName("order_hdrs")
    @Expose
    private List<OrderHdr> orderHdrs = null;
    @SerializedName("sync_time")
    @Expose
    private String syncTime;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;

    public List<OrderHdr> getOrderHdrs() {
        return orderHdrs;
    }

    @SerializedName("order_dtls")
    @Expose
    private List<OrderHdr.OrderDtl> orderDtl = null;

    @SerializedName("order_hdr_ext")
    @Expose
    private List<OrderHdr.OrderHdrExt> orderHdrExts= null;
    public List<OrderHdr.OrderDtl> getOrderDtls() {
        return orderDtl;
    }

    public List<OrderHdr.OrderDtl> getOrderDtl() {
        return orderDtl;
    }

    public void setOrderDtl(List<OrderHdr.OrderDtl> orderDtl) {
        this.orderDtl = orderDtl;
    }

    public List<OrderHdr.OrderHdrExt> getOrderHdrExts() {
        return orderHdrExts;
    }

    public void setOrderHdrExts(List<OrderHdr.OrderHdrExt> orderHdrExts) {
        this.orderHdrExts = orderHdrExts;
    }

    public void setOrderHdrs(List<OrderHdr> orderHdrs) {
        this.orderHdrs = orderHdrs;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class OrderHdr implements Serializable {

        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("order_no")
        @Expose
        private String orderNo;
        @SerializedName("shop_code")
        @Expose
        private String shopCode;
        @SerializedName("station_code")
        @Expose
        private String stationCode;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("order_date")
        @Expose
        private String orderDate;
        @SerializedName("order_time")
        @Expose
        private String orderTime;
        @SerializedName("shift_id")
        @Expose
        private String shiftId;
        @SerializedName("customer_id")
        @Expose
        private String customerId;
        @SerializedName("is_ar_customer")
        @Expose
        private String isArCustomer;
        @SerializedName("detail_total")
        @Expose
        private String detailTotal;
        @SerializedName("total_tax1")
        @Expose
        private String totalTax1;
        @SerializedName("total_tax2")
        @Expose
        private String totalTax2;
        @SerializedName("total_tax3")
        @Expose
        private String totalTax3;
        @SerializedName("total_gst")
        @Expose
        private String totalGst;
        @SerializedName("total_sc")
        @Expose
        private String totalSc;
        @SerializedName("total_detail_discount")
        @Expose
        private String totalDetailDiscount;
        @SerializedName("final_round_amount")
        @Expose
        private String finalRoundAmount;
        @SerializedName("total_amount")
        @Expose
        private String totalAmount;
        @SerializedName("total_amount_paid")
        @Expose
        private String totalAmountPaid;
        @SerializedName("total_balance")
        @Expose
        private String totalBalance;
        @SerializedName("actual_balance_paid")
        @Expose
        private String actualBalancePaid;
        @SerializedName("cash_out")
        @Expose
        private String cashOut;
        @SerializedName("remarks")
        @Expose
        private String remarks;
        @SerializedName("closing_date")
        @Expose
        private String closingDate;
        @SerializedName("closing_time")
        @Expose
        private String closingTime;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("total_print_count")
        @Expose
        private String totalPrintCount;
        @SerializedName("refund_total_tax1")
        @Expose
        private String refundTotalTax1;
        @SerializedName("refund_total_tax2")
        @Expose
        private String refundTotalTax2;
        @SerializedName("refund_total_tax3")
        @Expose
        private String refundTotalTax3;
        @SerializedName("refund_total_gst")
        @Expose
        private String refundTotalGst;
        @SerializedName("refund_total_sc")
        @Expose
        private String refundTotalSc;
        @SerializedName("refund_amount")
        @Expose
        private String refundAmount;
        @SerializedName("sync_message")
        @Expose
        private String syncMessage;
        @SerializedName("created_by")
        @Expose
        private String createdBy;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_by")
        @Expose
        private String updatedBy;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("sync_status")
        @Expose
        private String syncStatus;
        @SerializedName("bill_less_tax_amount")
        @Expose
        private String billLessTaxAmount;
        @SerializedName("bill_discount_amount")
        @Expose
        private String billDiscountAmount;
        @SerializedName("serving_table_id")
        @Expose
        private String servingTableId;
        @SerializedName("served_by")
        @Expose
        private String servedBy;
        @SerializedName("service_type")
        @Expose
        private String serviceType;
        @SerializedName("covers")
        @Expose
        private String covers;
        @SerializedName("order_customer")
        @Expose
        private OrderCustomer orderCustomer;
        @SerializedName("order_hdr_ext")
        @Expose
        private OrderHdrExt orderHdrExt;
        @SerializedName("order_payments")
        @Expose
        private List<OrderPayment> orderPayments = null;
        @SerializedName("order_dtls")
        @Expose
        private List<OrderDtl> orderDtls = null;

        public OrderCustomer getOrderHdrs() {
            return orderHdrs;
        }

        public void setOrderHdrs(OrderCustomer orderHdrs) {
            this.orderHdrs = orderHdrs;
        }

        @SerializedName("order_hdrs")
        @Expose
        private OrderCustomer orderHdrs;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getShopCode() {
            return shopCode;
        }

        public void setShopCode(String shopCode) {
            this.shopCode = shopCode;
        }

        public String getStationCode() {
            return stationCode;
        }

        public void setStationCode(String stationCode) {
            this.stationCode = stationCode;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getShiftId() {
            return shiftId;
        }

        public void setShiftId(String shiftId) {
            this.shiftId = shiftId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getIsArCustomer() {
            return isArCustomer;
        }

        public void setIsArCustomer(String isArCustomer) {
            this.isArCustomer = isArCustomer;
        }

        public String getDetailTotal() {
            return detailTotal;
        }

        public void setDetailTotal(String detailTotal) {
            this.detailTotal = detailTotal;
        }

        public String getTotalTax1() {
            return totalTax1;
        }

        public void setTotalTax1(String totalTax1) {
            this.totalTax1 = totalTax1;
        }

        public String getTotalTax2() {
            return totalTax2;
        }

        public void setTotalTax2(String totalTax2) {
            this.totalTax2 = totalTax2;
        }

        public String getTotalTax3() {
            return totalTax3;
        }

        public void setTotalTax3(String totalTax3) {
            this.totalTax3 = totalTax3;
        }

        public String getTotalGst() {
            return totalGst;
        }

        public void setTotalGst(String totalGst) {
            this.totalGst = totalGst;
        }

        public String getTotalSc() {
            return totalSc;
        }

        public void setTotalSc(String totalSc) {
            this.totalSc = totalSc;
        }

        public String getTotalDetailDiscount() {
            return totalDetailDiscount;
        }

        public void setTotalDetailDiscount(String totalDetailDiscount) {
            this.totalDetailDiscount = totalDetailDiscount;
        }

        public String getFinalRoundAmount() {
            return finalRoundAmount;
        }

        public void setFinalRoundAmount(String finalRoundAmount) {
            this.finalRoundAmount = finalRoundAmount;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getTotalAmountPaid() {
            return totalAmountPaid;
        }

        public void setTotalAmountPaid(String totalAmountPaid) {
            this.totalAmountPaid = totalAmountPaid;
        }

        public String getTotalBalance() {
            return totalBalance;
        }

        public void setTotalBalance(String totalBalance) {
            this.totalBalance = totalBalance;
        }

        public String getActualBalancePaid() {
            return actualBalancePaid;
        }

        public void setActualBalancePaid(String actualBalancePaid) {
            this.actualBalancePaid = actualBalancePaid;
        }

        public String getCashOut() {
            return cashOut;
        }

        public void setCashOut(String cashOut) {
            this.cashOut = cashOut;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getClosingDate() {
            return closingDate;
        }

        public void setClosingDate(String closingDate) {
            this.closingDate = closingDate;
        }

        public String getClosingTime() {
            return closingTime;
        }

        public void setClosingTime(String closingTime) {
            this.closingTime = closingTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTotalPrintCount() {
            return totalPrintCount;
        }

        public void setTotalPrintCount(String totalPrintCount) {
            this.totalPrintCount = totalPrintCount;
        }

        public String getRefundTotalTax1() {
            return refundTotalTax1;
        }

        public void setRefundTotalTax1(String refundTotalTax1) {
            this.refundTotalTax1 = refundTotalTax1;
        }

        public String getRefundTotalTax2() {
            return refundTotalTax2;
        }

        public void setRefundTotalTax2(String refundTotalTax2) {
            this.refundTotalTax2 = refundTotalTax2;
        }

        public String getRefundTotalTax3() {
            return refundTotalTax3;
        }

        public void setRefundTotalTax3(String refundTotalTax3) {
            this.refundTotalTax3 = refundTotalTax3;
        }

        public String getRefundTotalGst() {
            return refundTotalGst;
        }

        public void setRefundTotalGst(String refundTotalGst) {
            this.refundTotalGst = refundTotalGst;
        }

        public String getRefundTotalSc() {
            return refundTotalSc;
        }

        public void setRefundTotalSc(String refundTotalSc) {
            this.refundTotalSc = refundTotalSc;
        }

        public String getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(String refundAmount) {
            this.refundAmount = refundAmount;
        }

        public String getSyncMessage() {
            return syncMessage;
        }

        public void setSyncMessage(String syncMessage) {
            this.syncMessage = syncMessage;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getSyncStatus() {
            return syncStatus;
        }

        public void setSyncStatus(String syncStatus) {
            this.syncStatus = syncStatus;
        }

        public String getBillLessTaxAmount() {
            return billLessTaxAmount;
        }

        public void setBillLessTaxAmount(String billLessTaxAmount) {
            this.billLessTaxAmount = billLessTaxAmount;
        }

        public String getBillDiscountAmount() {
            return billDiscountAmount;
        }

        public void setBillDiscountAmount(String billDiscountAmount) {
            this.billDiscountAmount = billDiscountAmount;
        }

        public String getServingTableId() {
            return servingTableId;
        }

        public void setServingTableId(String servingTableId) {
            this.servingTableId = servingTableId;
        }

        public String getServedBy() {
            return servedBy;
        }

        public void setServedBy(String servedBy) {
            this.servedBy = servedBy;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getCovers() {
            return covers;
        }

        public void setCovers(String covers) {
            this.covers = covers;
        }

        public OrderCustomer getOrderCustomer() {
            return orderCustomer;
        }

        public void setOrderCustomer(OrderCustomer orderCustomer) {
            this.orderCustomer = orderCustomer;
        }

        public OrderHdrExt getOrderHdrExt() {
            return orderHdrExt;
        }

        public void setOrderHdrExt(OrderHdrExt orderHdrExt) {
            this.orderHdrExt = orderHdrExt;
        }

        public List<OrderPayment> getOrderPayments() {
            return orderPayments;
        }

        public void setOrderPayments(List<OrderPayment> orderPayments) {
            this.orderPayments = orderPayments;
        }

        public List<OrderDtl> getOrderDtls() {
            return orderDtls;
        }

        public void setOrderDtls(List<OrderDtl> orderDtls) {
            this.orderDtls = orderDtls;
        }

        public class OrderCustomer implements Serializable {

            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("customer_id")
            @Expose
            private String customerId;
            @SerializedName("customer_type")
            @Expose
            private String customerType;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("first_name")
            @Expose
            private String firstName;
            @SerializedName("last_name")
            @Expose
            private String lastName;
            @SerializedName("address")
            @Expose
            private String address;
            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("state")
            @Expose
            private String state;
            @SerializedName("country")
            @Expose
            private String country;
            @SerializedName("post_code")
            @Expose
            private String postCode;
            @SerializedName("gender")
            @Expose
            private String gender;
            @SerializedName("dob")
            @Expose
            private String dob;
            @SerializedName("phone_number")
            @Expose
            private String phoneNumber;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("is_deleted")
            @Expose
            private String isDeleted;

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getCustomerType() {
                return customerType;
            }

            public void setCustomerType(String customerType) {
                this.customerType = customerType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getPostCode() {
                return postCode;
            }

            public void setPostCode(String postCode) {
                this.postCode = postCode;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getDob() {
                return dob;
            }

            public void setDob(String dob) {
                this.dob = dob;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getIsDeleted() {
                return isDeleted;
            }

            public void setIsDeleted(String isDeleted) {
                this.isDeleted = isDeleted;
            }

        }

        public class OrderHdrExt implements Serializable {

            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("tax_invoice_no")
            @Expose
            private String taxInvoiceNo;
            @SerializedName("delivery_date")
            @Expose
            private String deliveryDate;
            @SerializedName("delivery_time")
            @Expose
            private String deliveryTime;
            @SerializedName("order_mail_receipt")
            @Expose
            private String orderMailReceipt;

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getTaxInvoiceNo() {
                return taxInvoiceNo;
            }

            public void setTaxInvoiceNo(String taxInvoiceNo) {
                this.taxInvoiceNo = taxInvoiceNo;
            }

            public String getDeliveryDate() {
                return deliveryDate;
            }

            public void setDeliveryDate(String deliveryDate) {
                this.deliveryDate = deliveryDate;
            }

            public String getDeliveryTime() {
                return deliveryTime;
            }

            public void setDeliveryTime(String deliveryTime) {
                this.deliveryTime = deliveryTime;
            }

            public String getOrderMailReceipt() {
                return orderMailReceipt;
            }

            public void setOrderMailReceipt(String orderMailReceipt) {
                this.orderMailReceipt = orderMailReceipt;
            }

        }

        public class OrderPayment implements Serializable {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("payment_mode")
            @Expose
            private String paymentMode;
            @SerializedName("paid_amount")
            @Expose
            private String paidAmount;
            @SerializedName("card_name")
            @Expose
            private String cardName;
            @SerializedName("card_type")
            @Expose
            private String cardType;
            @SerializedName("card_no")
            @Expose
            private String cardNo;
            @SerializedName("name_on_card")
            @Expose
            private String nameOnCard;
            @SerializedName("card_expiry_month")
            @Expose
            private String cardExpiryMonth;
            @SerializedName("card_expiry_year")
            @Expose
            private String cardExpiryYear;
            @SerializedName("card_approval_code")
            @Expose
            private String cardApprovalCode;
            @SerializedName("card_account_type")
            @Expose
            private String cardAccountType;
            @SerializedName("pos_customer_receipt")
            @Expose
            private String posCustomerReceipt;
            @SerializedName("pos_merchant_receipt")
            @Expose
            private String posMerchantReceipt;
            @SerializedName("company_id")
            @Expose
            private String companyId;
            @SerializedName("voucher_id")
            @Expose
            private String voucherId;
            @SerializedName("voucher_value")
            @Expose
            private String voucherValue;
            @SerializedName("voucher_count")
            @Expose
            private String voucherCount;
            @SerializedName("cashier_id")
            @Expose
            private String cashierId;
            @SerializedName("payment_date")
            @Expose
            private String paymentDate;
            @SerializedName("payment_time")
            @Expose
            private String paymentTime;
            @SerializedName("discount_id")
            @Expose
            private String discountId;
            @SerializedName("discount_code")
            @Expose
            private String discountCode;
            @SerializedName("discount_name")
            @Expose
            private String discountName;
            @SerializedName("discount_description")
            @Expose
            private String discountDescription;
            @SerializedName("discount_price")
            @Expose
            private String discountPrice;
            @SerializedName("discount_is_percentage")
            @Expose
            private String discountIsPercentage;
            @SerializedName("discount_is_overridable")
            @Expose
            private String discountIsOverridable;
            @SerializedName("discount_amount")
            @Expose
            private String discountAmount;
            @SerializedName("is_repayment")
            @Expose
            private String isRepayment;
            @SerializedName("is_voucher_balance_returned")
            @Expose
            private String isVoucherBalanceReturned;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getPaymentMode() {
                return paymentMode;
            }

            public void setPaymentMode(String paymentMode) {
                this.paymentMode = paymentMode;
            }

            public String getPaidAmount() {
                return paidAmount;
            }

            public void setPaidAmount(String paidAmount) {
                this.paidAmount = paidAmount;
            }

            public String getCardName() {
                return cardName;
            }

            public void setCardName(String cardName) {
                this.cardName = cardName;
            }

            public String getCardType() {
                return cardType;
            }

            public void setCardType(String cardType) {
                this.cardType = cardType;
            }

            public String getCardNo() {
                return cardNo;
            }

            public void setCardNo(String cardNo) {
                this.cardNo = cardNo;
            }

            public String getNameOnCard() {
                return nameOnCard;
            }

            public void setNameOnCard(String nameOnCard) {
                this.nameOnCard = nameOnCard;
            }

            public String getCardExpiryMonth() {
                return cardExpiryMonth;
            }

            public void setCardExpiryMonth(String cardExpiryMonth) {
                this.cardExpiryMonth = cardExpiryMonth;
            }

            public String getCardExpiryYear() {
                return cardExpiryYear;
            }

            public void setCardExpiryYear(String cardExpiryYear) {
                this.cardExpiryYear = cardExpiryYear;
            }

            public String getCardApprovalCode() {
                return cardApprovalCode;
            }

            public void setCardApprovalCode(String cardApprovalCode) {
                this.cardApprovalCode = cardApprovalCode;
            }

            public String getCardAccountType() {
                return cardAccountType;
            }

            public void setCardAccountType(String cardAccountType) {
                this.cardAccountType = cardAccountType;
            }

            public String getPosCustomerReceipt() {
                return posCustomerReceipt;
            }

            public void setPosCustomerReceipt(String posCustomerReceipt) {
                this.posCustomerReceipt = posCustomerReceipt;
            }

            public String getPosMerchantReceipt() {
                return posMerchantReceipt;
            }

            public void setPosMerchantReceipt(String posMerchantReceipt) {
                this.posMerchantReceipt = posMerchantReceipt;
            }

            public String getCompanyId() {
                return companyId;
            }

            public void setCompanyId(String companyId) {
                this.companyId = companyId;
            }

            public String getVoucherId() {
                return voucherId;
            }

            public void setVoucherId(String voucherId) {
                this.voucherId = voucherId;
            }

            public String getVoucherValue() {
                return voucherValue;
            }

            public void setVoucherValue(String voucherValue) {
                this.voucherValue = voucherValue;
            }

            public String getVoucherCount() {
                return voucherCount;
            }

            public void setVoucherCount(String voucherCount) {
                this.voucherCount = voucherCount;
            }

            public String getCashierId() {
                return cashierId;
            }

            public void setCashierId(String cashierId) {
                this.cashierId = cashierId;
            }

            public String getPaymentDate() {
                return paymentDate;
            }

            public void setPaymentDate(String paymentDate) {
                this.paymentDate = paymentDate;
            }

            public String getPaymentTime() {
                return paymentTime;
            }

            public void setPaymentTime(String paymentTime) {
                this.paymentTime = paymentTime;
            }

            public String getDiscountId() {
                return discountId;
            }

            public void setDiscountId(String discountId) {
                this.discountId = discountId;
            }

            public String getDiscountCode() {
                return discountCode;
            }

            public void setDiscountCode(String discountCode) {
                this.discountCode = discountCode;
            }

            public String getDiscountName() {
                return discountName;
            }

            public void setDiscountName(String discountName) {
                this.discountName = discountName;
            }

            public String getDiscountDescription() {
                return discountDescription;
            }

            public void setDiscountDescription(String discountDescription) {
                this.discountDescription = discountDescription;
            }

            public String getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(String discountPrice) {
                this.discountPrice = discountPrice;
            }

            public String getDiscountIsPercentage() {
                return discountIsPercentage;
            }

            public void setDiscountIsPercentage(String discountIsPercentage) {
                this.discountIsPercentage = discountIsPercentage;
            }

            public String getDiscountIsOverridable() {
                return discountIsOverridable;
            }

            public void setDiscountIsOverridable(String discountIsOverridable) {
                this.discountIsOverridable = discountIsOverridable;
            }

            public String getDiscountAmount() {
                return discountAmount;
            }

            public void setDiscountAmount(String discountAmount) {
                this.discountAmount = discountAmount;
            }

            public String getIsRepayment() {
                return isRepayment;
            }

            public void setIsRepayment(String isRepayment) {
                this.isRepayment = isRepayment;
            }

            public String getIsVoucherBalanceReturned() {
                return isVoucherBalanceReturned;
            }

            public void setIsVoucherBalanceReturned(String isVoucherBalanceReturned) {
                this.isVoucherBalanceReturned = isVoucherBalanceReturned;
            }

        }

        public class OrderDtl implements Serializable {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("sale_item_id")
            @Expose
            private String saleItemId;
            @SerializedName("sale_item_code")
            @Expose
            private String saleItemCode;
            @SerializedName("sub_class_id")
            @Expose
            private String subClassId;
            @SerializedName("sub_class_code")
            @Expose
            private String subClassCode;
            @SerializedName("sub_class_name")
            @Expose
            private String subClassName;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("alternative_name")
            @Expose
            private String alternativeName;
            @SerializedName("name_to_print")
            @Expose
            private String nameToPrint;
            @SerializedName("alternative_name_to_print")
            @Expose
            private String alternativeNameToPrint;
            @SerializedName("qty")
            @Expose
            private String qty;
            @SerializedName("is_open")
            @Expose
            private String isOpen;
            @SerializedName("is_combo_item")
            @Expose
            private String isComboItem;
            @SerializedName("is_tax1_applied")
            @Expose
            private String isTax1Applied;
            @SerializedName("is_tax2_applied")
            @Expose
            private String isTax2Applied;
            @SerializedName("is_tax3_applied")
            @Expose
            private String isTax3Applied;
            @SerializedName("is_gst_applied")
            @Expose
            private String isGstApplied;
            @SerializedName("is_tax1_included_in_gst")
            @Expose
            private String isTax1IncludedInGst;
            @SerializedName("is_tax2_included_in_gst")
            @Expose
            private String isTax2IncludedInGst;
            @SerializedName("is_tax3_included_in_gst")
            @Expose
            private String isTax3IncludedInGst;
            @SerializedName("is_sc_included_in_gst")
            @Expose
            private String isScIncludedInGst;
            @SerializedName("is_sc_applied")
            @Expose
            private String isScApplied;
            @SerializedName("is_printed_to_kitchen")
            @Expose
            private String isPrintedToKitchen;
            @SerializedName("remarks")
            @Expose
            private String remarks;
            @SerializedName("is_void")
            @Expose
            private String isVoid;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("uom_code")
            @Expose
            private String uomCode;
            @SerializedName("uom_name")
            @Expose
            private String uomName;
            @SerializedName("uom_symbol")
            @Expose
            private String uomSymbol;
            @SerializedName("fixed_price")
            @Expose
            private String fixedPrice;
            @SerializedName("tax_calculation_method")
            @Expose
            private String taxCalculationMethod;
            @SerializedName("tax_id")
            @Expose
            private String taxId;
            @SerializedName("tax_code")
            @Expose
            private String taxCode;
            @SerializedName("tax_name")
            @Expose
            private String taxName;
            @SerializedName("tax1_name")
            @Expose
            private String tax1Name;
            @SerializedName("tax1_pc")
            @Expose
            private String tax1Pc;
            @SerializedName("tax1_amount")
            @Expose
            private String tax1Amount;
            @SerializedName("tax2_name")
            @Expose
            private String tax2Name;
            @SerializedName("tax2_pc")
            @Expose
            private String tax2Pc;
            @SerializedName("tax2_amount")
            @Expose
            private String tax2Amount;
            @SerializedName("tax3_name")
            @Expose
            private String tax3Name;
            @SerializedName("tax3_pc")
            @Expose
            private String tax3Pc;
            @SerializedName("tax3_amount")
            @Expose
            private String tax3Amount;
            @SerializedName("sc_name")
            @Expose
            private String scName;
            @SerializedName("sc_pc")
            @Expose
            private String scPc;
            @SerializedName("sc_amount")
            @Expose
            private String scAmount;
            @SerializedName("gst_name")
            @Expose
            private String gstName;
            @SerializedName("gst_pc")
            @Expose
            private String gstPc;
            @SerializedName("gst_amount")
            @Expose
            private String gstAmount;
            @SerializedName("item_total")
            @Expose
            private String itemTotal;
            @SerializedName("discount_type")
            @Expose
            private String discountType;
            @SerializedName("discount_id")
            @Expose
            private String discountId;
            @SerializedName("discount_code")
            @Expose
            private String discountCode;
            @SerializedName("discount_name")
            @Expose
            private String discountName;
            @SerializedName("discount_description")
            @Expose
            private String discountdescription;
            @SerializedName("discount_price")
            @Expose
            private String discountPrice;
            @SerializedName("discount_is_percentage")
            @Expose
            private String discountIsPercentage;
            @SerializedName("discount_is_overridable")
            @Expose
            private String discountIsOverridable;
            @SerializedName("discount_is_item_specific")
            @Expose
            private String discountIsItemSpecific;
            @SerializedName("discount_is_promotion")
            @Expose
            private String discountIsPromotion;
            @SerializedName("discount_permitted_for")
            @Expose
            private String discountPermittedFor;
            @SerializedName("discount_amount")
            @Expose
            private String discountAmount;
            @SerializedName("discount_grouping_quantity")
            @Expose
            private String discountGroupingQuantity;
            @SerializedName("discount_allow_editing")
            @Expose
            private String discountAllowEditing;
            @SerializedName("round_adjustment")
            @Expose
            private String roundAdjustment;
            @SerializedName("attrib1_name")
            @Expose
            private String attrib1Name;
            @SerializedName("attrib1_options")
            @Expose
            private String attrib1Options;
            @SerializedName("attrib2_name")
            @Expose
            private String attrib2Name;
            @SerializedName("attrib2_options")
            @Expose
            private String attrib2Options;
            @SerializedName("attrib3_name")
            @Expose
            private String attrib3Name;
            @SerializedName("attrib3_options")
            @Expose
            private String attrib3Options;
            @SerializedName("attrib4_name")
            @Expose
            private String attrib4Name;
            @SerializedName("attrib4_options")
            @Expose
            private String attrib4Options;
            @SerializedName("attrib5_name")
            @Expose
            private String attrib5Name;
            @SerializedName("attrib5_options")
            @Expose
            private String attrib5Options;
            @SerializedName("attrib1_selected_option")
            @Expose
            private String attrib1SelectedOption;
            @SerializedName("attrib2_selected_option")
            @Expose
            private String attrib2SelectedOption;
            @SerializedName("attrib3_selected_option")
            @Expose
            private String attrib3SelectedOption;
            @SerializedName("attrib4_selected_option")
            @Expose
            private String attrib4SelectedOption;
            @SerializedName("attrib5_selected_option")
            @Expose
            private String attrib5SelectedOption;
            @SerializedName("cashier_id")
            @Expose
            private String cashierId;
            @SerializedName("order_date")
            @Expose
            private String orderDate;
            @SerializedName("order_time")
            @Expose
            private String orderTime;
            @SerializedName("customer_price_variance")
            @Expose
            private String customerPriceVariance;
            @SerializedName("discount_variants")
            @Expose
            private String discountVariants;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("service_type")
            @Expose
            private String service_type;
            @SerializedName("serving_table_id")
            @Expose
            private String serving_table_id;
            @SerializedName("served_by")
            @Expose
            private String served_by;


            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getSaleItemId() {
                return saleItemId;
            }

            public void setSaleItemId(String saleItemId) {
                this.saleItemId = saleItemId;
            }

            public String getSaleItemCode() {
                return saleItemCode;
            }

            public void setSaleItemCode(String saleItemCode) {
                this.saleItemCode = saleItemCode;
            }

            public String getSubClassId() {
                return subClassId;
            }

            public void setSubClassId(String subClassId) {
                this.subClassId = subClassId;
            }

            public String getSubClassCode() {
                return subClassCode;
            }

            public void setSubClassCode(String subClassCode) {
                this.subClassCode = subClassCode;
            }

            public String getSubClassName() {
                return subClassName;
            }

            public void setSubClassName(String subClassName) {
                this.subClassName = subClassName;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlternativeName() {
                return alternativeName;
            }

            public void setAlternativeName(String alternativeName) {
                this.alternativeName = alternativeName;
            }

            public String getNameToPrint() {
                return nameToPrint;
            }

            public void setNameToPrint(String nameToPrint) {
                this.nameToPrint = nameToPrint;
            }

            public String getAlternativeNameToPrint() {
                return alternativeNameToPrint;
            }

            public void setAlternativeNameToPrint(String alternativeNameToPrint) {
                this.alternativeNameToPrint = alternativeNameToPrint;
            }

            public String getQty() {
                return qty;
            }

            public void setQty(String qty) {
                this.qty = qty;
            }

            public String getIsOpen() {
                return isOpen;
            }

            public void setIsOpen(String isOpen) {
                this.isOpen = isOpen;
            }

            public String getIsComboItem() {
                return isComboItem;
            }

            public void setIsComboItem(String isComboItem) {
                this.isComboItem = isComboItem;
            }

            public String getIsTax1Applied() {
                return isTax1Applied;
            }

            public void setIsTax1Applied(String isTax1Applied) {
                this.isTax1Applied = isTax1Applied;
            }

            public String getIsTax2Applied() {
                return isTax2Applied;
            }

            public void setIsTax2Applied(String isTax2Applied) {
                this.isTax2Applied = isTax2Applied;
            }

            public String getIsTax3Applied() {
                return isTax3Applied;
            }

            public void setIsTax3Applied(String isTax3Applied) {
                this.isTax3Applied = isTax3Applied;
            }

            public String getIsGstApplied() {
                return isGstApplied;
            }

            public void setIsGstApplied(String isGstApplied) {
                this.isGstApplied = isGstApplied;
            }

            public String getIsTax1IncludedInGst() {
                return isTax1IncludedInGst;
            }

            public void setIsTax1IncludedInGst(String isTax1IncludedInGst) {
                this.isTax1IncludedInGst = isTax1IncludedInGst;
            }

            public String getIsTax2IncludedInGst() {
                return isTax2IncludedInGst;
            }

            public void setIsTax2IncludedInGst(String isTax2IncludedInGst) {
                this.isTax2IncludedInGst = isTax2IncludedInGst;
            }

            public String getIsTax3IncludedInGst() {
                return isTax3IncludedInGst;
            }

            public void setIsTax3IncludedInGst(String isTax3IncludedInGst) {
                this.isTax3IncludedInGst = isTax3IncludedInGst;
            }

            public String getIsScIncludedInGst() {
                return isScIncludedInGst;
            }

            public void setIsScIncludedInGst(String isScIncludedInGst) {
                this.isScIncludedInGst = isScIncludedInGst;
            }

            public String getIsScApplied() {
                return isScApplied;
            }

            public void setIsScApplied(String isScApplied) {
                this.isScApplied = isScApplied;
            }

            public String getIsPrintedToKitchen() {
                return isPrintedToKitchen;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public void setIsPrintedToKitchen(String isPrintedToKitchen) {
                this.isPrintedToKitchen = isPrintedToKitchen;
            }

            public String getIsVoid() {
                return isVoid;
            }

            public void setIsVoid(String isVoid) {
                this.isVoid = isVoid;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getUomCode() {
                return uomCode;
            }

            public void setUomCode(String uomCode) {
                this.uomCode = uomCode;
            }

            public String getUomName() {
                return uomName;
            }

            public void setUomName(String uomName) {
                this.uomName = uomName;
            }

            public String getUomSymbol() {
                return uomSymbol;
            }

            public void setUomSymbol(String uomSymbol) {
                this.uomSymbol = uomSymbol;
            }

            public String getFixedPrice() {
                return fixedPrice;
            }

            public void setFixedPrice(String fixedPrice) {
                this.fixedPrice = fixedPrice;
            }

            public String getTaxCalculationMethod() {
                return taxCalculationMethod;
            }

            public void setTaxCalculationMethod(String taxCalculationMethod) {
                this.taxCalculationMethod = taxCalculationMethod;
            }

            public String getTaxId() {
                return taxId;
            }

            public void setTaxId(String taxId) {
                this.taxId = taxId;
            }

            public String getTaxCode() {
                return taxCode;
            }

            public void setTaxCode(String taxCode) {
                this.taxCode = taxCode;
            }

            public String getTaxName() {
                return taxName;
            }

            public void setTaxName(String taxName) {
                this.taxName = taxName;
            }

            public String getTax1Name() {
                return tax1Name;
            }

            public void setTax1Name(String tax1Name) {
                this.tax1Name = tax1Name;
            }

            public String getTax1Pc() {
                return tax1Pc;
            }

            public void setTax1Pc(String tax1Pc) {
                this.tax1Pc = tax1Pc;
            }

            public String getTax1Amount() {
                return tax1Amount;
            }

            public void setTax1Amount(String tax1Amount) {
                this.tax1Amount = tax1Amount;
            }

            public String getTax2Name() {
                return tax2Name;
            }

            public void setTax2Name(String tax2Name) {
                this.tax2Name = tax2Name;
            }

            public String getTax2Pc() {
                return tax2Pc;
            }

            public void setTax2Pc(String tax2Pc) {
                this.tax2Pc = tax2Pc;
            }

            public String getTax2Amount() {
                return tax2Amount;
            }

            public void setTax2Amount(String tax2Amount) {
                this.tax2Amount = tax2Amount;
            }

            public String getTax3Name() {
                return tax3Name;
            }

            public void setTax3Name(String tax3Name) {
                this.tax3Name = tax3Name;
            }

            public String getTax3Pc() {
                return tax3Pc;
            }

            public String getTax3Amount() {
                return tax3Amount;
            }

            public void setTax3Amount(String tax3Amount) {
                this.tax3Amount = tax3Amount;
            }

            public void setTax3Pc(String tax3Pc) {
                this.tax3Pc = tax3Pc;
            }

            public String getScName() {
                return scName;
            }

            public void setScName(String scName) {
                this.scName = scName;
            }

            public String getScPc() {
                return scPc;
            }

            public void setScPc(String scPc) {
                this.scPc = scPc;
            }

            public String getScAmount() {
                return scAmount;
            }

            public void setScAmount(String scAmount) {
                this.scAmount = scAmount;
            }

            public String getGstName() {
                return gstName;
            }

            public void setGstName(String gstName) {
                this.gstName = gstName;
            }

            public String getGstPc() {
                return gstPc;
            }

            public void setGstPc(String gstPc) {
                this.gstPc = gstPc;
            }

            public String getGstAmount() {
                return gstAmount;
            }

            public void setGstAmount(String gstAmount) {
                this.gstAmount = gstAmount;
            }

            public String getItemTotal() {
                return itemTotal;
            }

            public void setItemTotal(String itemTotal) {
                this.itemTotal = itemTotal;
            }

            public String getDiscountType() {
                return discountType;
            }

            public void setDiscountType(String discountType) {
                this.discountType = discountType;
            }

            public String getDiscountId() {
                return discountId;
            }

            public void setDiscountId(String discountId) {
                this.discountId = discountId;
            }

            public String getDiscountCode() {
                return discountCode;
            }

            public void setDiscountCode(String discountCode) {
                this.discountCode = discountCode;
            }

            public String getDiscountName() {
                return discountName;
            }

            public String getDiscountdescription() {
                return discountdescription;
            }

            public void setDiscountdescription(String discountdescription) {
                this.discountdescription = discountdescription;
            }

            public void setDiscountName(String discountName) {
                this.discountName = discountName;
            }

            public String getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(String discountPrice) {
                this.discountPrice = discountPrice;
            }

            public String getDiscountIsPercentage() {
                return discountIsPercentage;
            }

            public void setDiscountIsPercentage(String discountIsPercentage) {
                this.discountIsPercentage = discountIsPercentage;
            }

            public String getDiscountIsOverridable() {
                return discountIsOverridable;
            }

            public void setDiscountIsOverridable(String discountIsOverridable) {
                this.discountIsOverridable = discountIsOverridable;
            }

            public String getDiscountIsItemSpecific() {
                return discountIsItemSpecific;
            }

            public void setDiscountIsItemSpecific(String discountIsItemSpecific) {
                this.discountIsItemSpecific = discountIsItemSpecific;
            }

            public String getDiscountIsPromotion() {
                return discountIsPromotion;
            }

            public void setDiscountIsPromotion(String discountIsPromotion) {
                this.discountIsPromotion = discountIsPromotion;
            }

            public String getDiscountPermittedFor() {
                return discountPermittedFor;
            }

            public void setDiscountPermittedFor(String discountPermittedFor) {
                this.discountPermittedFor = discountPermittedFor;
            }

            public String getDiscountAmount() {
                return discountAmount;
            }

            public void setDiscountAmount(String discountAmount) {
                this.discountAmount = discountAmount;
            }

            public String getDiscountGroupingQuantity() {
                return discountGroupingQuantity;
            }

            public void setDiscountGroupingQuantity(String discountGroupingQuantity) {
                this.discountGroupingQuantity = discountGroupingQuantity;
            }

            public String getDiscountAllowEditing() {
                return discountAllowEditing;
            }

            public void setDiscountAllowEditing(String discountAllowEditing) {
                this.discountAllowEditing = discountAllowEditing;
            }

            public String getRoundAdjustment() {
                return roundAdjustment;
            }

            public void setRoundAdjustment(String roundAdjustment) {
                this.roundAdjustment = roundAdjustment;
            }

            public String getAttrib1Name() {
                return attrib1Name;
            }

            public void setAttrib1Name(String attrib1Name) {
                this.attrib1Name = attrib1Name;
            }

            public String getAttrib1Options() {
                return attrib1Options;
            }

            public void setAttrib1Options(String attrib1Options) {
                this.attrib1Options = attrib1Options;
            }

            public String getAttrib2Name() {
                return attrib2Name;
            }

            public void setAttrib2Name(String attrib2Name) {
                this.attrib2Name = attrib2Name;
            }

            public String getAttrib2Options() {
                return attrib2Options;
            }

            public void setAttrib2Options(String attrib2Options) {
                this.attrib2Options = attrib2Options;
            }

            public String getAttrib3Name() {
                return attrib3Name;
            }

            public void setAttrib3Name(String attrib3Name) {
                this.attrib3Name = attrib3Name;
            }

            public String getAttrib3Options() {
                return attrib3Options;
            }

            public void setAttrib3Options(String attrib3Options) {
                this.attrib3Options = attrib3Options;
            }

            public String getAttrib4Name() {
                return attrib4Name;
            }

            public void setAttrib4Name(String attrib4Name) {
                this.attrib4Name = attrib4Name;
            }

            public String getAttrib4Options() {
                return attrib4Options;
            }

            public void setAttrib4Options(String attrib4Options) {
                this.attrib4Options = attrib4Options;
            }

            public String getAttrib5Name() {
                return attrib5Name;
            }

            public void setAttrib5Name(String attrib5Name) {
                this.attrib5Name = attrib5Name;
            }

            public String getAttrib5Options() {
                return attrib5Options;
            }

            public void setAttrib5Options(String attrib5Options) {
                this.attrib5Options = attrib5Options;
            }

            public String getAttrib1SelectedOption() {
                return attrib1SelectedOption;
            }

            public void setAttrib1SelectedOption(String attrib1SelectedOption) {
                this.attrib1SelectedOption = attrib1SelectedOption;
            }

            public String getAttrib2SelectedOption() {
                return attrib2SelectedOption;
            }

            public void setAttrib2SelectedOption(String attrib2SelectedOption) {
                this.attrib2SelectedOption = attrib2SelectedOption;
            }

            public String getAttrib3SelectedOption() {
                return attrib3SelectedOption;
            }

            public void setAttrib3SelectedOption(String attrib3SelectedOption) {
                this.attrib3SelectedOption = attrib3SelectedOption;
            }

            public String getAttrib4SelectedOption() {
                return attrib4SelectedOption;
            }

            public void setAttrib4SelectedOption(String attrib4SelectedOption) {
                this.attrib4SelectedOption = attrib4SelectedOption;
            }

            public String getAttrib5SelectedOption() {
                return attrib5SelectedOption;
            }

            public void setAttrib5SelectedOption(String attrib5SelectedOption) {
                this.attrib5SelectedOption = attrib5SelectedOption;
            }

            public String getCashierId() {
                return cashierId;
            }

            public void setCashierId(String cashierId) {
                this.cashierId = cashierId;
            }

            public String getOrderDate() {
                return orderDate;
            }

            public void setOrderDate(String orderDate) {
                this.orderDate = orderDate;
            }

            public String getOrderTime() {
                return orderTime;
            }

            public void setOrderTime(String orderTime) {
                this.orderTime = orderTime;
            }

            public String getCustomerPriceVariance() {
                return customerPriceVariance;
            }

            public void setCustomerPriceVariance(String customerPriceVariance) {
                this.customerPriceVariance = customerPriceVariance;
            }

            public String getDiscountVariants() {
                return discountVariants;
            }

            public void setDiscountVariants(String discountVariants) {
                this.discountVariants = discountVariants;
            }

            public String getService_type() {
                return service_type;
            }

            public void setService_type(String service_type) {
                this.service_type = service_type;
            }

            public String getServing_table_id() {
                return serving_table_id;
            }

            public void setServing_table_id(String serving_table_id) {
                this.serving_table_id = serving_table_id;
            }

            public String getServed_by() {
                return served_by;
            }

            public void setServed_by(String served_by) {
                this.served_by = served_by;
            }
        }

        public class OrderHistory implements Serializable {
            @SerializedName("id")
            @Expose
            public String id;
            @SerializedName("order_id")
            @Expose
            public String order_id;
            @SerializedName("shop_id")
            @Expose
            public String shopid;
            @SerializedName("status")
            @Expose
            public String status;
            @SerializedName("update_at")
            @Expose
            public String update_at;
            @SerializedName("sync_status")
            @Expose
            public String sync_status;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public String getShopid() {
                return shopid;
            }

            public void setShopid(String shopid) {
                this.shopid = shopid;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSync_status() {
                return sync_status;
            }

            public void setSync_status(String sync_status) {
                this.sync_status = sync_status;
            }
        }

        public class sync_status implements Serializable {
            @SerializedName("last_sync_at")
            @Expose
            private String last_sync_at;

            public String getLast_sync_at() {
                return last_sync_at;
            }

            public void setLast_sync_at(String last_sync_at) {
                this.last_sync_at = last_sync_at;
            }
        }

    }

}
