/**
 * Wire
 * Copyright (C) 2019 Wire Swiss GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.waz.db.migrate

import java.util
import java.util.concurrent.Executors

import android.content.Context
import com.waz.db.Migration
import com.waz.model.KeyValueData.KeyValueDataDao
import com.waz.utils.wrappers.DB
import com.wire.roomdb.{UserDatabase, UserPreference}

/**
  * Migration class that migrates user preference data held in legacy SQLite db to Room database.
  *
  * @param fromVersion prev version of the SQLite database.
  * @param toVersion next version of the SQLite database.
  * @param context context
  * @param dbName name of the legacy database. Required to distinguish between different users' preferences.
  */
class UserPrefsRoomMigration(override val fromVersion: Int,
                             override val toVersion: Int,
                             context: Context,
                             dbName: String)
    extends Migration {

  override def apply(db: DB): Unit = {
    val tableName = KeyValueDataDao.table.name
    val cursor = db.query(tableName, null, null, null, null, null, null)

    if (cursor.moveToFirst()) {
      val keyValues = new util.ArrayList[UserPreference]()
      do {
        keyValues.add(new UserPreference(cursor.getString(0), cursor.getString(1)))
      } while (cursor.moveToNext())

      Executors.newSingleThreadExecutor().execute(new Runnable {
        override def run(): Unit = {
          UserDatabase.getInstance(context, dbName)
            .userPreferencesDao()
            .insert(keyValues)
        }
      })
    }

    db.execSQL(s"DROP TABLE IF EXISTS $tableName")
  }
}
