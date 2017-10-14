class CreateUserDetails < ActiveRecord::Migration[5.1]
  def change
    create_table :user_details do |t|
      t.string :name
      t.string :flight_no
      t.datetime :departure_time
      t.datetime :arrival_time
      t.string :departue_dest
      t.string :arrival_dest
      t.string :pnr

      t.timestamps
    end
  end
end
d
