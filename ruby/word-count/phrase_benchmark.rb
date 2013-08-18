require 'benchmark'

class Phrase
  def initialize phrase
    @phrase = phrase
  end

  def word_count
    uniqwords = words.uniq
    duplwords = words
    Benchmark.bm do |x|
      x.report "uniq" do
        1.times do
          words_and_occurences = uniqwords.map do |word|
            [word, occurences(word)]
          end
        end
      end

      x.report "dupl" do
        1.times do
          words_and_occurences = duplwords.map do |word|
            [word, occurences(word)]
          end
        end
      end
    end
    Hash[words_and_occurences]
  end

  private

  def words
    @words ||= @phrase.downcase.gsub(/[^a-z0-9, ]/, '').split(/[, ]+/)
  end

  def occurences word
    words.count(word)
  end
end

book = File.read('/Users/marten/alice.txt')
Phrase.new(book).word_count