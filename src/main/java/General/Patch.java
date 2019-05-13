/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
/**
 *
 * @author irshed-pt2884
 */
public class Patch {

    @NotNull(message = "Patch : Id cannot be empty")
    @Length(min = 2, max = 5, message = "Id should be between 2 and 5 Length")
    private String patchid;
    @NotNull(message = "Patch : Name cannot be empty")
    @Length(min = 6, max = 20, message = "Name should be between 6 and 20 Length")
    private String patchname;
    @NotNull(message = "Patch : Vendor cannot be empty")
    private String vendor;
    @NotNull(message = "Patch : Status cannot be empty")
    @Length(min = 6, max = 20, message = "Status should be between 6 and 20 Length")
    private String status;

    public String getPatchid() {
        return patchid;
    }

    public void setPatchid(String patchid) {
        this.patchid = patchid;
    }

    public String getPatchname() {
        return patchname;
    }

    public void setPatchname(String patchname) {
        this.patchname = patchname;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
   

    public static Patch getPatchById(String id) {
        Patch p = new Patch();
        try {

            Connection con = Dbcon.DbCon.getConnection("user");
            String sql = "select * from patchdetails where patchid like ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p.setPatchid(id);
                p.setPatchname(rs.getString("patchname"));
                p.setVendor(rs.getString("vendor"));
                p.setStatus(rs.getString("status"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Patch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Patch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Patch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Patch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public static String insertPatch(Patch p) {
        int rs = 0;
        try {
            Connection con = Dbcon.DbCon.getConnection("user");
            String sql = "insert into patchdetails values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, p.getPatchid());
            st.setString(2, p.getPatchname());
            st.setString(3, p.getVendor());
            st.setString(4, p.getStatus());
            rs = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Patch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Patch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Patch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Patch.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rs == 1) {

            return "Updated";
        } else {

            return "Not Updated";
        }
    }

}
