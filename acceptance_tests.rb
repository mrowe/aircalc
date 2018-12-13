#!/usr/bin/env /usr/bin/ruby

require "open3"

# Run some simple smoke tests against the packaged app.

#`gradle clean check jar`

def check(message, input, expected)
   cmd = "java -jar build/libs/aircalc-1.0-SNAPSHOT.jar"
   Open3.popen2(cmd) do |stdin, stdout|
      input.each { |i| stdin.puts i }
      stdin.close
      actual = stdout.readlines.map{|a| a.strip}.drop(1)
      puts "#{message}: #{expected == actual ? "." : "got #{actual} expected #{expected}"}"
      @fail ||= (expected != actual)
   end
end

check "example 1",
  ["5 2"],
  ["[5, 2]"]

check "example 2",
   ["2 sqrt", "clear 9 sqrt"],
   ["[1.4142135624]", "[3]"]

check "example 3",
   ["5 2 -", "3 -", "clear"],
   ["[3]", "[0]", "[]"]

check "example 4",
   ["5 4 3 2", "undo undo *", "5 *", "undo"],
   ["[5, 4, 3, 2]", "[20]", "[100]", "[20, 5]"]

check "example 5",
   ["7 12 2 /", "*", "4 /"],
   ["[7, 6]", "[42]", "[10.5]"]

check "example 6",
   ["1 2 3 4 5", "*", "clear 3 4 -"],
   ["[1, 2, 3, 4, 5]", "[1, 2, 3, 20]", "[-1]"]

check "example 7",
   ["1 2 3 4 5", "* * * *"],
   ["[1, 2, 3, 4, 5]", "[120]"]

check "example 8",
   ["1 2 3 * 5 + * * 6 5"],
   ["[11]"]

puts
exit @fail ? 1 : 0