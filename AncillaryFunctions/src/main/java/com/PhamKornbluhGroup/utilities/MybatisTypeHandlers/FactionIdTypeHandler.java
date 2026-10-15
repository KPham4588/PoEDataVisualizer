package com.PhamKornbluhGroup.utilities.MybatisTypeHandlers;

import com.PhamKornbluhGroup.DTO.FactionId;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FactionIdTypeHandler<E extends FactionId> extends EnumTypeHandler<FactionId> {
    public FactionIdTypeHandler(Class<FactionId> type) {
        super(type);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, FactionId parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    @Override
    public FactionId getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return FactionId.fromFactionId(rs.getString(columnName));
    }

    @Override
    public FactionId getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return FactionId.fromFactionId(rs.getString(columnIndex));
    }

    @Override
    public FactionId getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return FactionId.fromFactionId(cs.getString(columnIndex));
    }

    private FactionId stringToEnum(String string) throws SQLException {
        FactionId factionId = switch (string) {
            case "Faction1" -> FactionId.FACTION1;
            case "Faction2" -> FactionId.FACTION2;
            case "Faction3" -> FactionId.FACTION3;
            case "Faction4" -> FactionId.FACTION4;
            default -> throw new SQLException("Failure in stringToEnum method of FactionIdTypeHandler");
        };
        return factionId;
    }
}