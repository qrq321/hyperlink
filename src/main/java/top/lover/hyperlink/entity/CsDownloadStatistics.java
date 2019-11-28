package top.lover.hyperlink.entity;

import java.io.Serializable;
import java.util.Date;

public class CsDownloadStatistics implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.N_ID
     *
     * @mbggenerated
     */
    private Long nId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.CHANNEL
     *
     * @mbggenerated
     */
    private Long channel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.PRODUCT
     *
     * @mbggenerated
     */
    private Long product;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.PRODUCT_NAME
     *
     * @mbggenerated
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.PHONE_SERIAL_NUM
     *
     * @mbggenerated
     */
    private String phoneSerialNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.SYSTEM_TYPE
     *
     * @mbggenerated
     */
    private Integer systemType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.DATA_SOURCE
     *
     * @mbggenerated
     */
    private Integer dataSource;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.RECORD_NUM
     *
     * @mbggenerated
     */
    private Integer recordNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.IMPORTER
     *
     * @mbggenerated
     */
    private Long importer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.STR0
     *
     * @mbggenerated
     */
    private String str0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.STR1
     *
     * @mbggenerated
     */
    private String str1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.COMP_ID
     *
     * @mbggenerated
     */
    private Long compId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.CREATE_BY
     *
     * @mbggenerated
     */
    private Long createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.MODI_BY
     *
     * @mbggenerated
     */
    private Long modiBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.MODI_TIME
     *
     * @mbggenerated
     */
    private Date modiTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.ORG_ID
     *
     * @mbggenerated
     */
    private Long orgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.SORT_NUM
     *
     * @mbggenerated
     */
    private Integer sortNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.STATUS
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_download_statistics.DOWNLOAD_NUM
     *
     * @mbggenerated
     */
    private Integer downloadNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_download_statistics
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.N_ID
     *
     * @return the value of cs_download_statistics.N_ID
     *
     * @mbggenerated
     */
    public Long getnId() {
        return nId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.N_ID
     *
     * @param nId the value for cs_download_statistics.N_ID
     *
     * @mbggenerated
     */
    public void setnId(Long nId) {
        this.nId = nId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.CHANNEL
     *
     * @return the value of cs_download_statistics.CHANNEL
     *
     * @mbggenerated
     */
    public Long getChannel() {
        return channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.CHANNEL
     *
     * @param channel the value for cs_download_statistics.CHANNEL
     *
     * @mbggenerated
     */
    public void setChannel(Long channel) {
        this.channel = channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.PRODUCT
     *
     * @return the value of cs_download_statistics.PRODUCT
     *
     * @mbggenerated
     */
    public Long getProduct() {
        return product;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.PRODUCT
     *
     * @param product the value for cs_download_statistics.PRODUCT
     *
     * @mbggenerated
     */
    public void setProduct(Long product) {
        this.product = product;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.PRODUCT_NAME
     *
     * @return the value of cs_download_statistics.PRODUCT_NAME
     *
     * @mbggenerated
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.PRODUCT_NAME
     *
     * @param productName the value for cs_download_statistics.PRODUCT_NAME
     *
     * @mbggenerated
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.PHONE_SERIAL_NUM
     *
     * @return the value of cs_download_statistics.PHONE_SERIAL_NUM
     *
     * @mbggenerated
     */
    public String getPhoneSerialNum() {
        return phoneSerialNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.PHONE_SERIAL_NUM
     *
     * @param phoneSerialNum the value for cs_download_statistics.PHONE_SERIAL_NUM
     *
     * @mbggenerated
     */
    public void setPhoneSerialNum(String phoneSerialNum) {
        this.phoneSerialNum = phoneSerialNum == null ? null : phoneSerialNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.SYSTEM_TYPE
     *
     * @return the value of cs_download_statistics.SYSTEM_TYPE
     *
     * @mbggenerated
     */
    public Integer getSystemType() {
        return systemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.SYSTEM_TYPE
     *
     * @param systemType the value for cs_download_statistics.SYSTEM_TYPE
     *
     * @mbggenerated
     */
    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.DATA_SOURCE
     *
     * @return the value of cs_download_statistics.DATA_SOURCE
     *
     * @mbggenerated
     */
    public Integer getDataSource() {
        return dataSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.DATA_SOURCE
     *
     * @param dataSource the value for cs_download_statistics.DATA_SOURCE
     *
     * @mbggenerated
     */
    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.RECORD_NUM
     *
     * @return the value of cs_download_statistics.RECORD_NUM
     *
     * @mbggenerated
     */
    public Integer getRecordNum() {
        return recordNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.RECORD_NUM
     *
     * @param recordNum the value for cs_download_statistics.RECORD_NUM
     *
     * @mbggenerated
     */
    public void setRecordNum(Integer recordNum) {
        this.recordNum = recordNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.IMPORTER
     *
     * @return the value of cs_download_statistics.IMPORTER
     *
     * @mbggenerated
     */
    public Long getImporter() {
        return importer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.IMPORTER
     *
     * @param importer the value for cs_download_statistics.IMPORTER
     *
     * @mbggenerated
     */
    public void setImporter(Long importer) {
        this.importer = importer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.STR0
     *
     * @return the value of cs_download_statistics.STR0
     *
     * @mbggenerated
     */
    public String getStr0() {
        return str0;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.STR0
     *
     * @param str0 the value for cs_download_statistics.STR0
     *
     * @mbggenerated
     */
    public void setStr0(String str0) {
        this.str0 = str0 == null ? null : str0.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.STR1
     *
     * @return the value of cs_download_statistics.STR1
     *
     * @mbggenerated
     */
    public String getStr1() {
        return str1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.STR1
     *
     * @param str1 the value for cs_download_statistics.STR1
     *
     * @mbggenerated
     */
    public void setStr1(String str1) {
        this.str1 = str1 == null ? null : str1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.COMP_ID
     *
     * @return the value of cs_download_statistics.COMP_ID
     *
     * @mbggenerated
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.COMP_ID
     *
     * @param compId the value for cs_download_statistics.COMP_ID
     *
     * @mbggenerated
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.CREATE_BY
     *
     * @return the value of cs_download_statistics.CREATE_BY
     *
     * @mbggenerated
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.CREATE_BY
     *
     * @param createBy the value for cs_download_statistics.CREATE_BY
     *
     * @mbggenerated
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.CREATE_TIME
     *
     * @return the value of cs_download_statistics.CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.CREATE_TIME
     *
     * @param createTime the value for cs_download_statistics.CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.MODI_BY
     *
     * @return the value of cs_download_statistics.MODI_BY
     *
     * @mbggenerated
     */
    public Long getModiBy() {
        return modiBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.MODI_BY
     *
     * @param modiBy the value for cs_download_statistics.MODI_BY
     *
     * @mbggenerated
     */
    public void setModiBy(Long modiBy) {
        this.modiBy = modiBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.MODI_TIME
     *
     * @return the value of cs_download_statistics.MODI_TIME
     *
     * @mbggenerated
     */
    public Date getModiTime() {
        return modiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.MODI_TIME
     *
     * @param modiTime the value for cs_download_statistics.MODI_TIME
     *
     * @mbggenerated
     */
    public void setModiTime(Date modiTime) {
        this.modiTime = modiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.ORG_ID
     *
     * @return the value of cs_download_statistics.ORG_ID
     *
     * @mbggenerated
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.ORG_ID
     *
     * @param orgId the value for cs_download_statistics.ORG_ID
     *
     * @mbggenerated
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.SORT_NUM
     *
     * @return the value of cs_download_statistics.SORT_NUM
     *
     * @mbggenerated
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.SORT_NUM
     *
     * @param sortNum the value for cs_download_statistics.SORT_NUM
     *
     * @mbggenerated
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.STATUS
     *
     * @return the value of cs_download_statistics.STATUS
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.STATUS
     *
     * @param status the value for cs_download_statistics.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_download_statistics.DOWNLOAD_NUM
     *
     * @return the value of cs_download_statistics.DOWNLOAD_NUM
     *
     * @mbggenerated
     */
    public Integer getDownloadNum() {
        return downloadNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_download_statistics.DOWNLOAD_NUM
     *
     * @param downloadNum the value for cs_download_statistics.DOWNLOAD_NUM
     *
     * @mbggenerated
     */
    public void setDownloadNum(Integer downloadNum) {
        this.downloadNum = downloadNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_download_statistics
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nId=").append(nId);
        sb.append(", channel=").append(channel);
        sb.append(", product=").append(product);
        sb.append(", productName=").append(productName);
        sb.append(", phoneSerialNum=").append(phoneSerialNum);
        sb.append(", systemType=").append(systemType);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", recordNum=").append(recordNum);
        sb.append(", importer=").append(importer);
        sb.append(", str0=").append(str0);
        sb.append(", str1=").append(str1);
        sb.append(", compId=").append(compId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", modiBy=").append(modiBy);
        sb.append(", modiTime=").append(modiTime);
        sb.append(", orgId=").append(orgId);
        sb.append(", sortNum=").append(sortNum);
        sb.append(", status=").append(status);
        sb.append(", downloadNum=").append(downloadNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}