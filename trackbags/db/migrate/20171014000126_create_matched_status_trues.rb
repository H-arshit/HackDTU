class CreateMatchedStatusTrues < ActiveRecord::Migration[5.1]
  def change
    create_table :matched_status_trues do |t|
      t.string :pnr

      t.timestamps
    end
  end
end
