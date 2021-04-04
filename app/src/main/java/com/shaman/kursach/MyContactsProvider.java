package com.shaman.kursach;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyContactsProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return new Cursor() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public int getPosition() {
                return 0;
            }

            @Override
            public boolean move(int offset) {
                return false;
            }

            @Override
            public boolean moveToPosition(int position) {
                return false;
            }

            @Override
            public boolean moveToFirst() {
                return false;
            }

            @Override
            public boolean moveToLast() {
                return false;
            }

            @Override
            public boolean moveToNext() {
                return false;
            }

            @Override
            public boolean moveToPrevious() {
                return false;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean isBeforeFirst() {
                return false;
            }

            @Override
            public boolean isAfterLast() {
                return false;
            }

            @Override
            public int getColumnIndex(String columnName) {
                return 0;
            }

            @Override
            public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
                return 0;
            }

            @Override
            public String getColumnName(int columnIndex) {
                return null;
            }

            @Override
            public String[] getColumnNames() {
                return new String[0];
            }

            @Override
            public int getColumnCount() {
                return 0;
            }

            @Override
            public byte[] getBlob(int columnIndex) {
                return new byte[0];
            }

            @Override
            public String getString(int columnIndex) {
                return null;
            }

            @Override
            public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {

            }

            @Override
            public short getShort(int columnIndex) {
                return 0;
            }

            @Override
            public int getInt(int columnIndex) {
                return 0;
            }

            @Override
            public long getLong(int columnIndex) {
                return 0;
            }

            @Override
            public float getFloat(int columnIndex) {
                return 0;
            }

            @Override
            public double getDouble(int columnIndex) {
                return 0;
            }

            @Override
            public int getType(int columnIndex) {
                return 0;
            }

            @Override
            public boolean isNull(int columnIndex) {
                return false;
            }

            @Override
            public void deactivate() {

            }

            @Override
            public boolean requery() {
                return false;
            }

            @Override
            public void close() {

            }

            @Override
            public boolean isClosed() {
                return false;
            }

            @Override
            public void registerContentObserver(ContentObserver observer) {

            }

            @Override
            public void unregisterContentObserver(ContentObserver observer) {

            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void setNotificationUri(ContentResolver cr, Uri uri) {

            }

            @Override
            public Uri getNotificationUri() {
                return null;
            }

            @Override
            public boolean getWantsAllOnMoveCalls() {
                return false;
            }

            @Override
            public void setExtras(Bundle extras) {

            }

            @Override
            public Bundle getExtras() {
                return null;
            }

            @Override
            public Bundle respond(Bundle extras) {
                return null;
            }
        };
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return String.valueOf(Employee.class);
    }

    public  List<Object> GetALL(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection){
        return Collections.singletonList(SQLWrapper.GetAll());
    }
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        try {
            Set<Map.Entry<String, Object>> contentSet=values.valueSet();
            for (Map.Entry<String,Object> entry :contentSet) {
                SQLWrapper.Add((Employee) entry.getValue());
            }
        }catch (Exception e){
         //ignored;
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int result;
        try {
            List<Employee> employees=SQLWrapper.MakeAQL(selection);
            for (Employee employee: employees) {
                SQLWrapper.Delete(employee);
            }
            result=0;
        }catch (Exception e){
            result=404;
        }
        return result;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int result;

        try {
            Set<Map.Entry<String, Object>> contentSet=values.valueSet();
            List<Employee> employees=SQLWrapper.MakeAQL(selection);

            List<Employee> employees1=employees;
            employees1.clear();
            for (Map.Entry<String,Object>  entry:contentSet){
                employees1.add((Employee) entry.getValue());
            }
            for (int i = 0; i < employees.size(); i++) {
                Employee employeeOld = employees.get(i);
                Employee employeeNew = employees1.get(i);
                SQLWrapper.Modify(employeeOld, employeeNew);
            }
            result=0;

        }catch (Exception e){
            result=404;
        }
        return result;
    }
}
