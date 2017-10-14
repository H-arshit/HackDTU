class CreateUnclaimeds < ActiveRecord::Migration[5.1]
  def change
    create_table :unclaimeds do |t|
      t.string :baggage_pnr

      t.timestamps
    end
  end
end
