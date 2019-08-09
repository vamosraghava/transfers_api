package net.devaction.entity;

import java.math.BigDecimal;

import net.devaction.entity.util.DateFormatter;

/**
 * @author Víctor Gil
 *
 * since August 2019
 */
public class TransferEntity{

    private String id;
    private String accountId;
    private BigDecimal amount;
    private long transferTS;
    
    @Override
    public String toString(){
        return "TransferEntity [id=" + id + 
                ", accountId=" + accountId + 
                ", amount=" + amount + 
                ", transferTS='" + getTransferDateTimeString() + " (" + transferTS + ")'" 
                + "]";
    }

    public TransferEntity(String id, String accountId, BigDecimal amount){
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        transferTS = System.currentTimeMillis();
    }

    public TransferEntity(String id, String accountId, BigDecimal amount, long transferTS){
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.transferTS = transferTS;
    }
    
    public TransferEntity(){}

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + (int) (transferTS ^ (transferTS >>> 32));
        
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        TransferEntity other = (TransferEntity) obj;
        
        // Since the id must be unique, it makes sense
        // that it is the first instance field to be checked
        if (id == null){
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        
        if (amount == null){
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        
        if (accountId == null){
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;
        
        if (transferTS != other.transferTS)
            return false;
        
        return true;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getAccountId(){
        return accountId;
    }

    public void setAccountId(String accountId){
        this.accountId = accountId;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    public long getTransferTS(){
        return transferTS;
    }

    public String getTransferDateTimeString(){
        return DateFormatter.getDateTimeString(transferTS);
    }
    
    public void setTransferTS(long transferTS){
        this.transferTS = transferTS;
    }    
}
