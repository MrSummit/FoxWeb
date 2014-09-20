# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20140920185930) do

  create_table "courses", force: true do |t|
    t.string   "course_name"
    t.string   "course_id"
    t.string   "year"
    t.string   "course_begin"
    t.string   "course_end"
    t.string   "lesson_begin"
    t.string   "lesson_end"
    t.string   "course_day"
    t.string   "teacher"
    t.string   "place"
    t.string   "grade_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "grades", force: true do |t|
    t.string   "grade"
    t.string   "name"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "profession"
    t.string   "college"
  end

  create_table "students", force: true do |t|
    t.string   "number"
    t.string   "name"
    t.string   "sex"
    t.string   "password"
    t.string   "grade_id"
    t.string   "year"
    t.string   "entrollmentTime"
    t.string   "orgin"
    t.string   "salt"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "users", force: true do |t|
    t.string   "user"
    t.string   "name"
    t.string   "password"
    t.string   "power"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "salt"
  end

end
