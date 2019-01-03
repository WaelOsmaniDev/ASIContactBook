package org.hexavibe.infrastructure.database.nosql;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "companies")
public class CompanyNoSQL {

    @Id
    public ObjectId _id;
    private String businessName;
    private String sirenNumber;

    public CompanyNoSQL() {
    }

    public CompanyNoSQL(ObjectId _id, String businessName, String sirenNumber) {
        this._id = _id;
        this.businessName = businessName;
        this.sirenNumber = sirenNumber;
    }

    // ObjectId needs to be converted to string
    public String get_id() { //TODO change id from Long to String
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getSirenNumber() {
        return sirenNumber;
    }

    public void setSirenNumber(String sirenNumber) {
        this.sirenNumber = sirenNumber;
    }
}
