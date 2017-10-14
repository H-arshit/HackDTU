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

ActiveRecord::Schema.define(version: 20171014055750) do

  create_table "matched_status_falses", force: :cascade do |t|
    t.string "baggage_pnr"
    t.string "pass_pnr"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "matched_status_trues", force: :cascade do |t|
    t.string "pnr"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "unclaimeds", force: :cascade do |t|
    t.string "baggage_pnr"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.string "location"
  end

  create_table "user_details", force: :cascade do |t|
    t.string "name"
    t.string "flight_no"
    t.datetime "departure_time"
    t.datetime "arrival_time"
    t.string "departue_dest"
    t.string "arrival_dest"
    t.string "pnr"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.integer "baggage_count"
    t.string "seat_no"
  end

end
