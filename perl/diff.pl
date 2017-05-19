#!/usr/bin/perl

use File::DirCompare;
 
# Simple diff -r --brief replacement
use File::Basename;
File::DirCompare->compare($dir1, $dir2, sub {
  my ($a, $b) = @_;
  if (! $b) {
    printf "Only in %s: %s\n", dirname($a), basename($a);
  } elsif (! $a) {
    printf "Only in %s: %s\n", dirname($b), basename($b);
  } else {
    print "Files $a and $b differ\n";
  }
});
 
# Version-control like Deleted/Added/Modified listing
my (@listing, @modified);     # use closure to collect results
File::DirCompare->compare('old_tree', 'new_tree', sub {
  my ($a, $b) = @_;
  if (! $b) {
    push @listing, "D   $a";
  } elsif (! $a) {
    push @listing, "A   $b";
  } else {
    if (-f $a && -f $b) {
      push @listing, "M   $b";
      push @modified, $b;
    } else {
      # One file, one directory - treat as delete + add
      push @listing, "D   $a";
      push @listing, "A   $b";
    }
  }
});
