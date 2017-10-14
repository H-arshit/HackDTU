class CreateMatchedStatusFalses < ActiveRecord::Migration[5.1]
  def change
    create_table :matched_status_falses do |t|
      t.string :baggage_pnr
      t.string :pass_pnr

      t.timestamps
    end
  end
end
